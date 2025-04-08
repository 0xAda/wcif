package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record RegistrationInfo(
        @JsonProperty("openTime") @JsonFormat(shape = JsonFormat.Shape.STRING) Instant openTime,
        @JsonProperty("closeTime") @JsonFormat(shape = JsonFormat.Shape.STRING) Instant closeTime,
        @JsonProperty("baseEntryFee") Integer baseEntryFee,
        @JsonProperty("currencyCode") String currencyCode,
        @JsonProperty("onTheSpotRegistration") boolean onTheSpotRegistration,
        @JsonProperty("useWcaRegistration") boolean useWcaRegistration
) {
}
