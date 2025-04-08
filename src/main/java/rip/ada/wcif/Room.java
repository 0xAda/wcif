package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Room(
        @JsonProperty("id") int id,
        @JsonProperty("name") String name,
        @JsonProperty("color") String color,
        @JsonProperty("activities") List<Activity> activities,
        @JsonProperty("extensions") List<Extension> extensions
) {
}
