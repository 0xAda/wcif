package rip.ada.wcif.event;

import rip.ada.wcif.EventType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Event codes from https://icons.cubing.net/
public enum UnofficialEvent implements EventType {
    MULTI_BLIND_OLD_STYLE("333mbo", "3x3x3 Multi-Blind Old Style"),
    THREE_BY_THREE_WITH_FEET("333ft", "3x3x3 With Feet"),
    MAGIC("magic", "Magic"),
    MASTER_MAGIC("mmagic", "Master Magic"),
    TWO_BY_TWO_BLD("222bf", "2x2x2 Blindfolded"),
    TWO_BY_TWO_ONE_HANDED("222oh", "2x2x2 One Handed"),
    TWO_TO_SEVEN_RELAY("234567relay", "2x2x2 to 7x7x7 Relay"),
    TWO_TO_SEVEN_RELAY_2_PERSON("234567relay_2_person", "2 Person 2x2x2 to 7x7x7 Relay"),
    TWO_TO_SIX_RELAY("23456relay", "2x2x2 to 6x6x6 Relay"),
    TWO_TO_FIVE_RELAY("2345relay", "2x2x2 to 5x5x5 Relay"),
    TWO_TO_FOUR_RELAY("234relay", "2x2x2 to 4x4x4 Relay"),
    THREE_BY_THREE_LINEAR_FEWEST_MOVES("333_linear_fm", "3x3x3 Linear Fewest Moves"),
    THREE_BY_THREE_MIRROR_BLOCKS("333_mirror_blocks", "3x3x3 Mirror Blocks"),
    THREE_BY_THREE_MIRROR_BLOCKS_BLD("333_mirror_blocks_bld", "3x3x3 Mirror Blocks Blindfolded"),
    THREE_BY_THREE_ONE_HANDED_AND_BLD_RELAY("333_oh_bld_relay", "3x3x3, 3x3x3 One Handed, and 3x3x3 Blindfolded Relay"),
    THREE_BY_THREE_ONE_HANDED_AND_BLD_TEAM_RELAY("333_oh_bld_team_relay", "3x3x3, 3x3x3 One Handed, and 3x3x3 Blindfolded Team Relay"),
    THREE_BY_THREE_SIAMESE("333_siamese", "3x3x3 Siamese Cube"),
    THREE_BY_THREE_SPEED_BLD("333_speed_bld", "3x3x3 Speed Blindfolded"),
    THREE_BY_THREE_TEAM_BLD("333_team_bld", "3x3x3 Team Blindfolded"),
    THREE_BY_THREE_TEAM_FACTORY("333_team_factory", "3x3x3 Team Factory"),
    THREE_BY_THREE_BLD_2_PERSON_RELAY("333bf_2_person_relay", "3x3x3 Blindfolded 2 Person Relay"),
    THREE_BY_THREE_BLD_3_PERSON_RELAY("333bf_3_person_relay", "3x3x3 Blindfolded 3 Person Relay"),
    THREE_BY_THREE_BLD_4_PERSON_RELAY("333bf_4_person_relay", "3x3x3 Blindfolded 4 Person Relay"),
    THREE_BY_THREE_BLD_8_PERSON_RELAY("333bf_8_person_relay", "3x3x3 Blindfolded 8 Person Relay"),
    THREE_BY_THREE_MATCH_THE_SCRAMBLE("333mts", "3x3x3 Match The Scramble"),
    FOUR_BY_FOUR_WITH_FEET("444ft", "4x4x4 With Feet"),
    SIX_BY_SIX_BLD("666bf", "6x6x6 Blindfolded"),
    SEVEN_BY_SEVEN_BLD("777bf", "7x7x7 Blindfolded"),
    BABY_FTO("baby_fto", "Baby Face-Turning Octahedron"),
    CURVYCOPTER("curvycopter", "Curvycopter"),
    FISHER_CUBE("fisher", "Fisher Cube"),
    FTO("fto", "Face-Turning Octahedron"),
    HELICOPTER_CUBE("helicopter", "Helicopter Cube"),
    KILOMINX("kilominx", "Kilominx"),
    MAGIC_ONE_HANDED("magic_oh", "Magic One Handed"),
    MINI_GUILDFORD("miniguild", "Mini Guildford"),
    MINI_GUILDFORD_2_PERSON("miniguild_2_person", "Mini Guildford 2 Person"),
    MINI_GUILDFORD_BLD("miniguild_bld", "Mini Guildford Blindfolded"),
    MEGAMINX_BLD("minx_bld", "Megaminx Blindfolded"),
    MASTER_PYRAMINX("mpyram", "Master Pyraminx"),
    MASTER_SKEWB("mskewb", "Master Skewb"),
    MASTER_TETRAMINX("mtetram", "Master Tetraminx"),
    PYRAMORPHIX("pyramorphix", "Pyramorphix"),
    REDI_CUBE("redi", "Redi Cube"),
    SQUARE_ONE_BLD("sq1_bld", "Square-1 Blindfolded");

    private static final Map<String, UnofficialEvent> ID_TO_EVENT;
    private final String eventId;
    private final String friendlyName;

    static {
        final Map<String, UnofficialEvent> map = new HashMap<>();
        for (final UnofficialEvent value : values()) {
            map.put(value.eventId, value);
        }
        ID_TO_EVENT = Collections.unmodifiableMap(map);
    }

    UnofficialEvent(final String eventId, final String friendlyName) {
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
        return true;
    }

    @Override
    public boolean isWcaEvent() {
        return false;
    }

    public static UnofficialEvent fromString(final String wcaEventId) {
        return ID_TO_EVENT.get(wcaEventId);
    }

}
