package rip.ada.wcif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import rip.ada.wcif.event.OfficialEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTest {

    private static final String EXAMPLE = "{\n" +
            "          \"id\" : 1,\n" +
            "          \"name\" : \"Clock, Round 1\",\n" +
            "          \"activityCode\" : \"clock-r1\",\n" +
            "          \"startTime\" : \"2024-11-01T09:45:00Z\",\n" +
            "          \"endTime\" : \"2024-11-01T10:30:00Z\",\n" +
            "          \"childActivities\" : [ {\n" +
            "            \"id\" : 693,\n" +
            "            \"name\" : \"Clock, Round 1, Group 1\",\n" +
            "            \"activityCode\" : \"clock-r1-g1\",\n" +
            "            \"startTime\" : \"2024-11-01T09:45:00Z\",\n" +
            "            \"endTime\" : \"2024-11-01T10:07:00Z\",\n" +
            "            \"childActivities\" : [ ],\n" +
            "            \"extensions\" : [ ]\n" +
            "          }, {\n" +
            "            \"id\" : 695,\n" +
            "            \"name\" : \"Clock, Round 1, Group 2\",\n" +
            "            \"activityCode\" : \"clock-r1-g2\",\n" +
            "            \"startTime\" : \"2024-11-01T10:07:00Z\",\n" +
            "            \"endTime\" : \"2024-11-01T10:30:00Z\",\n" +
            "            \"childActivities\" : [ ],\n" +
            "            \"extensions\" : [ ]\n" +
            "          } ],\n" +
            "          \"extensions\" : [ ]\n" +
            "        }";

    @Test
    public void shouldDeserializeActivity() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        final Activity activity = mapper.readValue(EXAMPLE, Activity.class);
        assertEquals(new ActivityCode(OfficialEvent.CLOCK, 1, null, null), activity.getActivityCode());
    }

}
