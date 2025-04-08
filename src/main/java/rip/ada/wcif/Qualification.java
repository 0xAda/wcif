package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record Qualification(
        @JsonProperty("whenDate") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate deadline,
        @JsonProperty("type") QualificationType type,
        @JsonProperty("resultType") ResultType resultType,
        @JsonProperty("level") AttemptResult level //TODO: This isn't technically the right type
) {
}
