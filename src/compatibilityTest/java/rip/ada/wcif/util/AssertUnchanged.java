package rip.ada.wcif.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;

public class AssertUnchanged {

    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    public static void assertUnchanged(final String urlBase, final String file, final String hash) throws IOException, InterruptedException, NoSuchAlgorithmException {
        final String content = getFileWithRetries(urlBase, file, 5);
        final String actualHash = sha256(content);
        assertEquals(hash, actualHash, "The hash of " + file + " has changed, this likely means changes need porting into this library. Look at recent commits to the WCA repo.");
    }

    private static String getFileWithRetries(final String urlBase, final String file, final int retryCount) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder(URI.create(urlBase + file)).GET().build();
        final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() > 200 && response.statusCode() < 500) {
            fail("File " + file + " no longer exists on GitHub. Got status " + response.statusCode() + " when requesting.");
        }

        if (response.statusCode() > 499) {
            System.err.println("Got a " + response.statusCode() + " response from GitHub, retrying");
            if (retryCount == 0) {
                abort("Failed to get " + file + " from GitHub, skipping test.");
            }
            return getFileWithRetries(urlBase, file, retryCount - 1);
        }
        return response.body();
    }

    public static String sha256(final String content) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(content.getBytes(StandardCharsets.UTF_8));
        final StringBuilder hexString = new StringBuilder();
        for (final byte b : hash) {
            final String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
