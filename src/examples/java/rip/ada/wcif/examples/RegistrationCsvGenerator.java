package rip.ada.wcif.examples;

import rip.ada.wcif.Competition;
import rip.ada.wcif.Event;
import rip.ada.wcif.Person;
import rip.ada.wcif.RegistrationStatus;

import java.util.Locale;
import java.util.StringJoiner;

import static rip.ada.wcif.examples.util.GetWcif.getCompetitionById;

public class RegistrationCsvGenerator {

    public static void main(final String[] args) {
        final Competition competition = getCompetitionById("RubiksUKChampionship2024");
        final StringJoiner events = new StringJoiner(",");
        for (final Event event : competition.getEvents()) {
            events.add(event.eventType().getEventId());
        }

        System.out.println("Status,Name,Country,WCA ID,Birth Date,Gender," + events + ",Email,Guests,IP,Registration Date Time (UTC),Payment Date Time(UTC),User Id,Registration Status");
        for (final Person person : competition.getPersons()) {
            if (person.registration() == null) {
                continue;
            }
            final StringJoiner line = new StringJoiner(",");
            line.add(person.registration().registrationStatus() == RegistrationStatus.ACCEPTED ? "a" : "p");
            line.add(person.name());
            line.add(person.country().getName());
            line.add(person.wcaId());
            line.add("1970-01-01"); // Not available in public WCIF
            line.add(person.gender().getLetter());

            for (final Event event : competition.getEvents()) {
                line.add(person.registration().events().contains(event.eventType()) ? "1" : "0");
            }

            line.add(person.email()); // Not available in public WCIF
            line.add(String.valueOf(person.registration().guests())); // Not available in public WCIF
            line.add(""); // Not available in WCIF
            line.add(""); // Not available in WCIF
            line.add(""); // Not available in WCIF
            line.add(String.valueOf(person.wcaUserId()));
            line.add(person.registration().registrationStatus().toString().toLowerCase(Locale.ROOT));
            System.out.println(line);
        }
    }

}
