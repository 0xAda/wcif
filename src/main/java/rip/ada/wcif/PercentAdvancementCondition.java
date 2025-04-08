package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PercentAdvancementCondition(@JsonProperty("level") int percent) implements AdvancementCondition {
}
