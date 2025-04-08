package rip.ada.wcif;

import org.junit.jupiter.api.Test;
import rip.ada.wcif.util.AssertUnchanged;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class WCIFSpecificationTest {

    @Test
    public void shouldNotHaveChangedWCIFSpec() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("specification.md", "83b7fafe1316fa5107a351cac44116903419adb7d716d61d7755c0f96ddf4a67");
    }

    private static void assertUnchanged(final String file, final String hash) throws IOException, NoSuchAlgorithmException, InterruptedException {
        AssertUnchanged.assertUnchanged("https://raw.githubusercontent.com/thewca/wcif/refs/heads/master/", file, hash);
    }

}
