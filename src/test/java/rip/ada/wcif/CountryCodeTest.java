package rip.ada.wcif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryCodeTest {

    @Test
    public void shouldSerializeCountryCode() throws JsonProcessingException {
        assertEquals("\"GB\"", new ObjectMapper().writeValueAsString(CountryCode.GB));
    }

    @Test
    public void shouldDeserializeCountryCode() throws JsonProcessingException {
        assertEquals(CountryCode.GB, new ObjectMapper().readValue("\"GB\"", CountryCode.class));
    }

}
