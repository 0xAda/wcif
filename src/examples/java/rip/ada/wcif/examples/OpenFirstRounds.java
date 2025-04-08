package rip.ada.wcif.examples;

import rip.ada.wcif.Competition;
import rip.ada.wcif.Event;
import rip.ada.wcif.Person;
import rip.ada.wcif.Result;
import rip.ada.wcif.Round;

import static rip.ada.wcif.examples.util.GetWcif.getCompetitionByIdPrivate;

public class OpenFirstRounds {

    public static void main(final String[] args) {
        final Competition competition = getCompetitionByIdPrivate("BristolSquockDay2024");
        for (final Event event : competition.getEvents()) {
            for (final Round round : event.rounds()) {
                if (round.roundNumber() != 1) {
                    continue;
                }
                for (final Person person : competition.getPersons()) {
                    if (person.registration() == null || !person.registration().events().contains(round.event())) {
                        continue;
                    }

                    round.results().add(Result.empty(person.registrantId()));
                }
            }
        }

        System.out.println(competition);
    }

}
