package rip.ada.wcif.event;

import rip.ada.wcif.EventType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ScheduleEvent implements EventType {
    REGISTRATION("registration", "Registration"),
    CHECKIN("checkin", "Check-in"),
    TUTORIAL("tutorial", "New Competitor Tutorial"),
    MULTI_BLD_SUBMISSION("multi", "Cube submission for 3x3x3 Multi-Blind"),
    BREAKFAST("breakfast", "Breakfast"),
    LUNCH("lunch", "Lunch"),
    DINNER("dinner", "Dinner"),
    AWARDS("awards", "Awards"),
    SETUP("setup", "Venue Setup"),
    TEARDOWN("teardown", "Venue Teardown"),
    MISC("misc", "Miscellaneous");

    private static final Map<String, ScheduleEvent> ID_TO_EVENT;
    private final String eventId;
    private final String friendlyName;

    static {
        final Map<String, ScheduleEvent> map = new HashMap<>();
        for (final ScheduleEvent value : values()) {
            map.put(value.eventId, value);
        }
        ID_TO_EVENT = Collections.unmodifiableMap(map);
    }

    ScheduleEvent(final String eventId, final String friendlyName) {
        this.eventId = eventId;
        this.friendlyName = friendlyName;
    }

    @Override
    public String getEventId() {
        return eventId;
    }

    @Override
    public String getFriendlyName() {
        return friendlyName;
    }

    @Override
    public boolean isCompetingEvent() {
        return false;
    }

    @Override
    public boolean isWcaEvent() {
        return false;
    }

    public static EventType fromString(final String eventId) {
        final ScheduleEvent scheduleEvent = ID_TO_EVENT.get(eventId);
        if (scheduleEvent != null) {
            return scheduleEvent;
        }
        return new UnrecognizedScheduleEvent(eventId);
    }
}
