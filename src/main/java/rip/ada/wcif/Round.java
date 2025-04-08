package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Round(
        @JsonProperty("id") ActivityCode activityCode,
        @JsonProperty("format") RoundFormat format,
        @JsonProperty("timeLimit") TimeLimit timeLimit,
        @JsonProperty("cutoff") Cutoff cutoff,
        @JsonProperty("advancementCondition") AdvancementCondition advancementCondition,
        @JsonProperty("results") List<Result> results,
        @JsonProperty("scrambleSetCount") int scrambleSetCount,
        @JsonProperty("scrambleSets") @JsonInclude(JsonInclude.Include.NON_NULL) List<ScrambleSet> scrambleSets,
        @JsonProperty("extensions") List<Extension> extensions
) {

    public Integer roundNumber() {
        return activityCode().round();
    }

    public EventType event() {
        return activityCode().event();
    }
}
