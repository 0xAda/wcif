package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Assignment(@JsonProperty("activityId") int activityId,
                         @JsonProperty("assignmentCode") AssignmentCode assignmentCode,
                         @JsonProperty("stationNumber") Integer stationNumber) {
}
