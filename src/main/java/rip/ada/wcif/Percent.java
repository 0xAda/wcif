package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record Percent(@JsonValue int percent) {
    public Percent {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent must be between 0 and 100, was: " + percent);
        }
    }

    @JsonCreator
    public static Percent fromInt(final int percent) {
        return new Percent(percent);
    }
}
