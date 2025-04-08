package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;
import rip.ada.wcif.event.OfficialEvent;

public record PersonalBest(
        @JsonProperty("eventId") OfficialEvent event,
        @JsonProperty("best") AttemptResult best,
        @JsonProperty("type") ResultType type,
        @JsonProperty("worldRanking") int worldRanking,
        @JsonProperty("continentalRanking") int continentalRanking,
        @JsonProperty("nationalRanking") int nationalRanking
) {
}
