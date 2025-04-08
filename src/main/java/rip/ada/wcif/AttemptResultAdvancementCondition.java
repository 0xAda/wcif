package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AttemptResultAdvancementCondition(
        @JsonProperty("level") AttemptResult attemptResult) implements AdvancementCondition {
}
