package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Cutoff(@JsonProperty("numberOfAttempts") int numberOfAttempts,
                     @JsonProperty("attemptResult") AttemptResult attemptResult) {
}
