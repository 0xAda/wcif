package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Result(
        @JsonProperty("personId") int personId,
        @JsonProperty("ranking") Integer ranking,
        @JsonProperty("attempts") List<Attempt> attempts,
        @JsonProperty("best") AttemptResult best,
        @JsonProperty("average") AttemptResult average
) {
    public static Result empty(final int personId) {
        return new Result(personId, null, List.of(), new AttemptResult(0), new AttemptResult(0));
    }
}
