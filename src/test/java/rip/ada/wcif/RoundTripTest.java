package rip.ada.wcif;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTripTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Test
    public void shouldHaveTheSameCompetitionAfterReadingWritingThenReadingAgain() throws IOException {
        final InputStream inputStream = RoundTripTest.class.getClassLoader().getResourceAsStream("private-wcif.json");
        final Competition read = OBJECT_MAPPER.readValue(inputStream, Competition.class);
        final String write = OBJECT_MAPPER.writeValueAsString(read);
        final Competition readAgain = OBJECT_MAPPER.readValue(write, Competition.class);

        assertEquals(read, readAgain, "Should have the same competition after writing and reading again");
    }

    @Test
    public void shouldHaveSameJsonAfterWritingBackOut() throws IOException {
        final InputStream secondInputStream = RoundTripTest.class.getClassLoader().getResourceAsStream("private-wcif.json");
        final JsonNode jsonNodeFromSource = OBJECT_MAPPER.readTree(secondInputStream);

        final InputStream inputStream = RoundTripTest.class.getClassLoader().getResourceAsStream("private-wcif.json");
        final Competition read = OBJECT_MAPPER.readValue(inputStream, Competition.class);
        final String write = OBJECT_MAPPER.writeValueAsString(read);
        final JsonNode jsonNodeFromCompetition = OBJECT_MAPPER.readTree(write);

        assertEquals(jsonNodeFromSource, jsonNodeFromCompetition, "Should have the same competition after writing and reading again");
    }

}
