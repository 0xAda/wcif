package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Attempt(@JsonProperty("result") AttemptResult result,
                      @JsonProperty("reconstruction") String reconstruction) {
}
