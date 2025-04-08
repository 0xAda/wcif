package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResultType {
    SINGLE("single"),
    AVERAGE("average");

    @JsonValue
    private final String jsonValue;


    ResultType(final String jsonValue) {
        this.jsonValue = jsonValue;
    }
}
