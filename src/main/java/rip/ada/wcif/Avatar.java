package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Avatar(@JsonProperty("url") String url, @JsonProperty("thumbUrl") String thumbnailUrl) {
}
