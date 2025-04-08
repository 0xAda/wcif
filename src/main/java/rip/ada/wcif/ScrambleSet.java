package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ScrambleSet(@JsonProperty("id") int id,
                          @JsonProperty("scrambles") List<String> scrambles,
                          @JsonProperty("extraScrambles") List<String> extraScrambles) {
}
