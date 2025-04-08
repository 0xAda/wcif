package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import rip.ada.wcif.event.OfficialEvent;
import rip.ada.wcif.event.UnofficialEvent;
import rip.ada.wcif.event.UnrecognizedUnofficialEvent;

public interface EventType {

    @JsonValue
    String getEventId();

    String getFriendlyName();

    boolean isCompetingEvent();

    boolean isWcaEvent();

    default boolean isRemoved() {
        return false;
    }

    @JsonCreator
    static EventType fromEventId(final String eventId) {
        final OfficialEvent officialEvent = OfficialEvent.fromString(eventId);
        if (officialEvent != null) {
            return officialEvent;
        }
        final UnofficialEvent unofficialEvent = UnofficialEvent.fromString(eventId);
        if (unofficialEvent != null) {
            return unofficialEvent;
        }

        return new UnrecognizedUnofficialEvent(eventId);
    }

}
