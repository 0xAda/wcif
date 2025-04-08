package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Series(@JsonProperty("id") String id, @JsonProperty("name") String name,
                     @JsonProperty("shortName") String shortName,
                     @JsonProperty("competitionIds") List<String> competitionIds) {
}
