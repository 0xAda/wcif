package rip.ada.wcif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import rip.ada.wcif.event.OfficialEvent;
import rip.ada.wcif.event.UnofficialEvent;
import rip.ada.wcif.event.UnrecognizedUnofficialEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTypeTest {

    @Test
    public void shouldSerializeEvent() throws JsonProcessingException {
        assertEquals("\"333\"", new ObjectMapper().writeValueAsString(OfficialEvent.THREE_BY_THREE));
    }


    @Test
    public void shouldDeserializeEvent() throws JsonProcessingException {
        assertEquals(OfficialEvent.THREE_BY_THREE, new ObjectMapper().readValue("\"333\"", EventType.class));
    }

    @Test
    public void shouldSerializeUnofficialEvent() throws JsonProcessingException {
        assertEquals("\"222bf\"", new ObjectMapper().writeValueAsString(UnofficialEvent.TWO_BY_TWO_BLD));
    }

    @Test
    public void shouldDeserializeUnofficialEvent() throws JsonProcessingException {
        assertEquals(UnofficialEvent.TWO_BY_TWO_BLD, new ObjectMapper().readValue("\"222bf\"", EventType.class));
    }

    @Test
    public void shouldDeserializeUnknownEvent() throws JsonProcessingException {
        assertEquals(new UnrecognizedUnofficialEvent("12345"), new ObjectMapper().readValue("\"12345\"", EventType.class));
    }

}
