package rip.ada.wcif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PercentTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void shouldSerializePercentages() throws JsonProcessingException {
        for (int i = 0; i < 100; i++) {
            assertEquals("" + i, OBJECT_MAPPER.writeValueAsString(new Percent(i)));
            assertEquals(new Percent(i), OBJECT_MAPPER.readValue("" + i, Percent.class));
        }
    }

    @Test
    public void shouldRejectHighPercentage() {
        assertThrows(ValueInstantiationException.class, () -> OBJECT_MAPPER.readValue("101", Percent.class));
    }

    @Test
    public void shouldRejectLowPercentage() {
        assertThrows(ValueInstantiationException.class, () -> OBJECT_MAPPER.readValue("-1", Percent.class));
    }

}
