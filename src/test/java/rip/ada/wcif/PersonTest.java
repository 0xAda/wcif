package rip.ada.wcif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    public void shouldParsePerson() throws JsonProcessingException {
        final Person person = OBJECT_MAPPER.readValue("{\n" +
                "  \"registrantId\": 1,\n" +
                "  \"name\": \"Sherlock Holmes\",\n" +
                "  \"wcaUserId\": 221,\n" +
                "  \"wcaId\": \"2015HOLM01\",\n" +
                "  \"countryIso2\": \"GB\",\n" +
                "  \"gender\": \"m\",\n" +
                "  \"birthdate\": \"1854-06-20\",\n" +
                "  \"email\": \"sholmes@gmail.com\",\n" +
                "  \"avatar\": {},\n" +
                "  \"roles\": [],\n" +
                "  \"registration\": {},\n" +
                "  \"assignments\": [],\n" +
                "  \"personalBests\": [],\n" +
                "  \"extensions\": []\n" +
                "}", Person.class);

        assertEquals(person.country(), CountryCode.GB);

    }

}
