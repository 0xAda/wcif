package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TimeLimit(@JsonProperty("centiseconds") int centiseconds,
                        //TODO: The spec says this is a String, but it looks suspiciously activity code shaped
                        @JsonProperty("cumulativeRoundIds") List<ActivityCode> cumulativeRoundIds) {
}
