package rip.ada.wcif;

import org.junit.jupiter.api.Test;
import rip.ada.wcif.util.AssertUnchanged;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class WCIFSpecificationTest {

    @Test
    public void shouldNotHaveChangedWCIFSpec() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("specification.md", "a46e19893873a31b13caa67d1077ce6889f97062d463960ac779f12675da62e1");
    }

    private static void assertUnchanged(final String file, final String hash) throws IOException, NoSuchAlgorithmException, InterruptedException {
        AssertUnchanged.assertUnchanged("https://raw.githubusercontent.com/thewca/wcif/refs/heads/master/", file, hash);
    }

}
