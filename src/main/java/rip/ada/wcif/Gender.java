package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE("m"),
    FEMALE("f"),
    OTHER("o");

    @JsonValue
    private final String letter;

    Gender(final String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}