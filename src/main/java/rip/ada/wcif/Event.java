package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import rip.ada.wcif.event.OfficialEvent;

import java.util.List;

public record Event(
        @JsonProperty("id") OfficialEvent eventType,
        @JsonProperty("rounds") List<Round> rounds,
        @JsonProperty("competitorLimit") @JsonInclude(JsonInclude.Include.NON_NULL) Integer competitorLimit,
        @JsonProperty("qualification") Qualification qualification,
        @JsonProperty("extensions") List<Extension> extensions
) {
}
