package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonValue;

public enum QualificationType {
    ATTEMPT_RESULT("attemptResult"),
    RANKING("ranking"),
    ANY_RESULT("anyResult");

    @JsonValue
    private final String jsonValue;

    QualificationType(final String jsonValue) {
        this.jsonValue = jsonValue;
    }
}
