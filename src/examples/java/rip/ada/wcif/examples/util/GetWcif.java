package rip.ada.wcif.examples.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import rip.ada.wcif.Competition;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetWcif {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    public static Competition getCompetitionById(final String id) {
        try {
            final HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.worldcubeassociation.org/api/v0/competitions/" + id + "/wcif/public")).GET().build();
            final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Got error response from WCA, status " + response.statusCode() + ". Error: " + response.body());
            }
            return OBJECT_MAPPER.readValue(response.body(), Competition.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Competition getCompetitionByIdPrivate(final String id) {
        try {
            final HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.worldcubeassociation.org/api/v0/competitions/" + id + "/wcif"))
                    .GET()
                    .header("Authorization", "Bearer " + System.getenv("TOKEN"))
                    .build();
            final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Got error response from WCA, status " + response.statusCode() + ". Error: " + response.body());
            }
            return OBJECT_MAPPER.readValue(response.body(), Competition.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
