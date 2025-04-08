package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record Role(@JsonValue String role) {
    public static final Role DELEGATE = new Role("delegate");
    public static final Role TRAINEE_DELEGATE = new Role("trainee-delegate");
    public static final Role ORGANIZER = new Role("organizer");

    @JsonCreator
    public static Role fromString(final String role) {
        return new Role(role);
    }

}
