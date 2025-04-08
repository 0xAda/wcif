package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes(
        value = {
                @JsonSubTypes.Type(name = "ranking", value = RankingAdvancementCondition.class),
                @JsonSubTypes.Type(name = "percent", value = PercentAdvancementCondition.class),
                @JsonSubTypes.Type(name = "attemptResult", value = AttemptResultAdvancementCondition.class)
        }
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface AdvancementCondition {
}
