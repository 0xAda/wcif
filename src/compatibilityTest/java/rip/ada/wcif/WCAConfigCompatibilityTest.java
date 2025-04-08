package rip.ada.wcif;

import org.junit.jupiter.api.Test;
import rip.ada.wcif.util.AssertUnchanged;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class WCAConfigCompatibilityTest {

    @Test
    public void shouldNotHaveChangedCountries() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("config/wca-states.json", "896f4ae4816e1e2652cbb1e4c9cd61288b63af77c6a3c5f23846565f434c036f");
    }

    @Test
    public void shouldNotHaveChangedRoundTypes() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("lib/static_data/round_types.json", "d52f35ee056461a461055db6f7d192cbe791115ec0effe5cb99e84695b7c4987");
    }

    @Test
    public void shouldNotHaveChangedPreferredFormats() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("lib/static_data/preferred_formats.json", "5d46cdbf6050d678b7405a7588b07fbbf8c09f7a39b34991ae34229348a9764a");
    }

    @Test
    public void shouldNotHaveChangedFormats() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("lib/static_data/formats.json", "a2706cf6316442d998cb101492dcd0fc641323a8e59dbc2d1aa412e0989a6e03");
    }

    @Test
    public void shouldNotHaveChangedEvents() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("lib/static_data/events.json", "9f785a4feb4d265e827c5a91b59034d840052c03aa27e93bde61cffec6148d26");
    }

    @Test
    public void shouldNotHaveChangedContinents() throws IOException, NoSuchAlgorithmException, InterruptedException {
        assertUnchanged("lib/static_data/continents.json", "eecf8eeccedd57a89b029bcd3aa15b5079ceedc64bc929dbe30aceb9f6686089");
    }

    private static void assertUnchanged(final String file, final String hash) throws IOException, NoSuchAlgorithmException, InterruptedException {
        AssertUnchanged.assertUnchanged("https://raw.githubusercontent.com/thewca/worldcubeassociation.org/refs/heads/main/", file, hash);
    }


}
