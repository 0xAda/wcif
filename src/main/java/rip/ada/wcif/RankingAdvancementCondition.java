package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RankingAdvancementCondition(@JsonProperty("level") int ranking) implements AdvancementCondition {
}
