package rip.ada.wcif.event;

import com.fasterxml.jackson.annotation.JsonValue;
import rip.ada.wcif.EventType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum OfficialEvent implements EventType {
    THREE_BY_THREE("333", "3x3x3 Cube", false),
    TWO_BY_TWO("222", "2x2x2 Cube", false),
    FOUR_BY_FOUR("444", "4x4x4 Cube", false),
    FIVE_BY_FIVE("555", "5x5x5 Cube", false),
    SIX_BY_SIX("666", "6x6x6 Cube", false),
    SEVEN_BY_SEVEN("777", "7x7x7 Cube", false),
    THREE_BLIND("333bf", "3x3x3 Blindfolded", false),
    FOUR_BLIND("444bf", "4x4x4 Blindfolded", false),
    FIVE_BLIND("555bf", "5x5x5 Blindfolded", false),
    ONE_HANDED("333oh", "3x3x3 One-Handed", false),
    CLOCK("clock", "Clock", false),
    MEGAMINX("minx", "Megaminx", false),
    PYRAMINX("pyram", "Pyraminx", false),
    SKEWB("skewb", "Skewb", false),
    MULTI_BLIND("333mbf", "3x3x3 Multi-Blind", false),
    SQUARE_ONE("sq1", "Square-1", false),
    FMC("333fm", "3x3x3 Fewest Moves", false),
    //Removed events, still need to be able to parse in WCIF
    MULTI_BLIND_OLD_STYLE("333mbo", "3x3x3 Multi-Blind Old Style", true),
    THREE_BY_THREE_WITH_FEET("333ft", "3x3x3 With Feet", true),
    MAGIC("magic", "Magic", true),
    MASTER_MAGIC("mmagic", "Master Magic", true);

    private static final Map<String, OfficialEvent> ID_TO_EVENT;
    private final String wcaEventId;
    private final String friendlyName;
    private final boolean removed;

    static {
        final Map<String, OfficialEvent> map = new HashMap<>();
        for (final OfficialEvent value : values()) {
            map.put(value.wcaEventId, value);
        }
        ID_TO_EVENT = Collections.unmodifiableMap(map);
    }

    OfficialEvent(final String wcaEventId, final String friendlyName, final boolean removed) {
        this.wcaEventId = wcaEventId;
        this.friendlyName = friendlyName;
        this.removed = removed;
    }

    @JsonValue
    @Override
    public String getEventId() {
        return wcaEventId;
    }

    @Override
    public String getFriendlyName() {
        return friendlyName;
    }

    @Override
    public boolean isCompetingEvent() {
        return true;
    }

    @Override
    public boolean isWcaEvent() {
        return true;
    }

    @Override
    public boolean isRemoved() {
        return removed;
    }

    public static OfficialEvent fromString(final String wcaEventId) {
        return ID_TO_EVENT.get(wcaEventId);
    }
}
