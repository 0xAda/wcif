package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public record Extension(@JsonProperty("id") String id, @JsonProperty("specUrl") String specUrl,
                        @JsonProperty("data") JsonNode data) {
}
