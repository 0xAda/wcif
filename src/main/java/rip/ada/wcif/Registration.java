package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Registration(
        @JsonProperty("wcaRegistrationId") int wcaRegistrationId,
        @JsonProperty("eventIds") List<EventType> events,
        @JsonProperty("status") RegistrationStatus registrationStatus,
        @JsonProperty("guests") Integer guests,
        @JsonProperty("comments") String comments,
        @JsonProperty("administrativeNotes") String administrativeNotes,
        @JsonProperty("isCompeting") boolean isCompeting
) {
}
