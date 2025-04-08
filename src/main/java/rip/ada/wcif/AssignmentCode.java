package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public interface AssignmentCode {
    @JsonValue
    String asString();

    @JsonCreator
    static AssignmentCode fromString(final String code) {
        for (final StandardAssignmentCode value : StandardAssignmentCode.values()) {
            if (value.asString().equals(code)) {
                return value;
            }
        }

        if (!code.startsWith("staff-")) {
            throw new IllegalArgumentException("Custom assignment codes must start with 'staff-' (got: '" + code + "')");
        }
        return new NonStandardAssignmentCode(code);
    }
}
