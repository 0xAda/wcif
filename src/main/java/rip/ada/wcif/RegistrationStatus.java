package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RegistrationStatus {
    ACCEPTED("accepted"),
    PENDING("pending"),
    DELETED("deleted");

    @JsonValue
    private final String value;

    RegistrationStatus(final String value) {
        this.value = value;
    }
}
