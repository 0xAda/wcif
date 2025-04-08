package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonValue;

public record NonStandardAssignmentCode(@JsonValue String assignmentCode) implements AssignmentCode {
    @Override
    public String asString() {
        return assignmentCode;
    }
}
