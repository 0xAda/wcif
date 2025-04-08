package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import rip.ada.wcif.event.OfficialEvent;
import rip.ada.wcif.event.ScheduleEvent;
import rip.ada.wcif.event.UnofficialEvent;
import rip.ada.wcif.event.UnrecognizedUnofficialEvent;

public record ActivityCode(EventType event, Integer round, Integer group, Integer attempt) {

    public String getDisplayName() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(event.getFriendlyName());

        if (round != null) {
            stringBuilder.append(", Round ");
            stringBuilder.append(round);
        }

        if (group != null) {
            stringBuilder.append(", Group ");
            stringBuilder.append(group);
        }

        if (attempt != null) {
            stringBuilder.append(", attempt ");
            stringBuilder.append(attempt);
        }

        return stringBuilder.toString();
    }

    @JsonCreator
    public static ActivityCode fromString(final String string) {
        if (string.startsWith("other-") && !string.startsWith("other-unofficial-")) {
            return new ActivityCode(ScheduleEvent.fromString(string.substring("other-".length())), null, null, null);
        }
        final String[] parts = string.split("-");

        if (string.startsWith("other-unofficial-")) {
            EventType event = UnofficialEvent.fromString(parts[2]);
            if (event == null) {
                event = new UnrecognizedUnofficialEvent(parts[2]);
            }

            return fromEventAndComponents(event, parts, 3);
        }
        final EventType event = OfficialEvent.fromString(parts[0]);
        return fromEventAndComponents(event, parts, 1);
    }

    private static ActivityCode fromEventAndComponents(final EventType event, final String[] parts, final int startIndex) {
        Integer round = null;
        Integer group = null;
        Integer attempt = null;

        for (int i = startIndex; i < parts.length; i++) {
            final String section = parts[i];
            final int number = Integer.parseInt(section.substring(1));
            if (section.startsWith("r")) {
                round = number;
            } else if (section.startsWith("g")) {
                group = number;
            } else if (section.startsWith("a")) {
                attempt = number;
            }
        }
        return new ActivityCode(event, round, group, attempt);
    }

    @JsonValue
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (!event.isWcaEvent()) {
            stringBuilder.append("other-");
            if (event.isCompetingEvent()) {
                stringBuilder.append("unofficial-");
            }
        }

        stringBuilder.append(event.getEventId());

        if (round != null) {
            stringBuilder.append("-r");
            stringBuilder.append(round);
        }
        if (group != null) {
            stringBuilder.append("-g");
            stringBuilder.append(group);
        }
        if (attempt != null) {
            stringBuilder.append("-a");
            stringBuilder.append(attempt);
        }

        return stringBuilder.toString();
    }

}
