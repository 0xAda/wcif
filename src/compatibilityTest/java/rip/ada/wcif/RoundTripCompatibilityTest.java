package rip.ada.wcif;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTripCompatibilityTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    public static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();


    @ParameterizedTest(name = "{0}")
    @MethodSource("allCompetitions")
    @Retention(RetentionPolicy.RUNTIME)
    private @interface TestCompetitions {
    }

    public static Stream<Arguments> allCompetitions() {
        return Stream.of(
                Arguments.of("RubiksUKChampionship2024"),
                Arguments.of("GlasgowSpringSBO2025"),
                Arguments.of("FMC2024"),
                Arguments.of("WC2023"),
                Arguments.of("WC2025")
        );
    }

    @TestCompetitions
    public void shouldHaveTheSameCompetitionAfterReadingWritingThenReadingAgain(final String competition) throws IOException {
        final String jsonString = getCompetitionJson(competition);
        final Competition read = OBJECT_MAPPER.readValue(jsonString, Competition.class);
        final String write = OBJECT_MAPPER.writeValueAsString(read);
        final Competition readAgain = OBJECT_MAPPER.readValue(write, Competition.class);

        assertEquals(read, readAgain, "Should have the same competition after writing and reading again");
    }

    @TestCompetitions
    public void shouldHaveSameJsonAfterWritingBackOut(final String competition) throws IOException {
        final String jsonString = getCompetitionJson(competition);
        final JsonNode jsonNodeFromSource = OBJECT_MAPPER.readTree(jsonString);

        final Competition read = OBJECT_MAPPER.readValue(jsonString, Competition.class);
        final String write = OBJECT_MAPPER.writeValueAsString(read);
        final JsonNode jsonNodeFromCompetition = OBJECT_MAPPER.readTree(write);

        assertJsonEquals(jsonNodeFromSource, jsonNodeFromCompetition, competition);
    }

    private static void assertJsonEquals(final JsonNode expected, final JsonNode actual, final String competition) throws IOException {
        if (!expected.equals(actual)) {
            Files.writeString(Path.of("expected-" + competition + ".json"), OBJECT_MAPPER.writeValueAsString(expected));
            Files.writeString(Path.of("actual-" + competition + ".json"), OBJECT_MAPPER.writeValueAsString(actual));
        }
        assertEquals(expected, actual, "Should have the same competition after writing and reading again");
    }

    private String getCompetitionJson(final String competitionId) {
        try {
            final HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.worldcubeassociation.org/api/v0/competitions/" + competitionId + "/wcif/public")).GET().build();
            final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Got error response from WCA, status " + response.statusCode() + ". Error: " + response.body());
            }
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
