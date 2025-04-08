package rip.ada.wcif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import rip.ada.wcif.event.OfficialEvent;
import rip.ada.wcif.event.ScheduleEvent;
import rip.ada.wcif.event.UnofficialEvent;
import rip.ada.wcif.event.UnrecognizedScheduleEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityCodeTest {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void shouldSerializeCheckIn() {
        assertActivityCode("other-checkin", new ActivityCode(ScheduleEvent.CHECKIN, null, null, null));
    }

    @Test
    public void shouldSerialize3x3Round1() {
        assertActivityCode("333-r1", new ActivityCode(OfficialEvent.THREE_BY_THREE, 1, null, null));
    }

    @Test
    public void shouldSerialize3x3Round1Group1() {
        assertActivityCode("333-r1-g1", new ActivityCode(OfficialEvent.THREE_BY_THREE, 1, 1, null));
    }

    @Test
    public void shouldSerializeFMCRound1Attempt1() {
        assertActivityCode("333fm-r1-a1", new ActivityCode(OfficialEvent.FMC, 1, null, 1));
    }

    @Test
    public void shouldSerializeFMCRound1Group1Attempt1() {
        assertActivityCode("333fm-r1-g1-a1", new ActivityCode(OfficialEvent.FMC, 1, 1, 1));
    }

    @Test
    public void shouldSerializeMisc() {
        assertActivityCode("other-misc", new ActivityCode(ScheduleEvent.MISC, null, null, null));
    }

    @Test
    public void shouldSerializeUserSpecifiedMisc() {
        assertActivityCode("other-misc-test", new ActivityCode(new UnrecognizedScheduleEvent("misc-test"), null, null, null));
    }

    @Test
    public void shouldSerializeUnofficialEvent() {
        assertActivityCode("other-unofficial-fto", new ActivityCode(UnofficialEvent.FTO, null, null, null));
    }

    @Test
    public void shouldSerializeUnofficialEventRound1() {
        assertActivityCode("other-unofficial-fto-r1", new ActivityCode(UnofficialEvent.FTO, 1, null, null));
    }

    @Test
    public void shouldSerializeUnofficialEventRound1Group1() {
        assertActivityCode("other-unofficial-fto-r1-g1", new ActivityCode(UnofficialEvent.FTO, 1, 1, null));
    }

    @Test
    public void shouldSerializeOfficialMagicEventRound1Group1() {
        assertActivityCode("magic-r1-g1", new ActivityCode(OfficialEvent.MAGIC, 1, 1, null));
    }

    @Test
    public void shouldSerializeUnofficialMagicEventRound1Group1() {
        assertActivityCode("other-unofficial-magic-r1-g1", new ActivityCode(UnofficialEvent.MAGIC, 1, 1, null));
    }

    private void assertActivityCode(final String string, final ActivityCode activityCode) {
        try {
            assertEquals(activityCode, OBJECT_MAPPER.readValue("\"" + string + "\"", ActivityCode.class));
            assertEquals("\"" + string + "\"", OBJECT_MAPPER.writeValueAsString(activityCode));
        } catch (final JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
