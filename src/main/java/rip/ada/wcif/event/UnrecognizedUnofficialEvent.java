package rip.ada.wcif.event;

import rip.ada.wcif.EventType;

public record UnrecognizedUnofficialEvent(String eventId) implements EventType {
    @Override
    public String getEventId() {
        return eventId;
    }

    @Override
    public String getFriendlyName() {
        return eventId;
    }

    @Override
    public boolean isCompetingEvent() {
        return true;
    }

    @Override
    public boolean isWcaEvent() {
        return false;
    }
}
