package rip.ada.wcif.examples;

import rip.ada.wcif.Competition;
import rip.ada.wcif.EventType;
import rip.ada.wcif.Person;

import java.util.HashMap;
import java.util.Map;

import static rip.ada.wcif.examples.util.GetWcif.getCompetitionById;

public class EventCounts {

    public static void main(final String[] args) {
        final Competition competition = getCompetitionById("RubiksUKChampionship2024");

        final Map<EventType, Integer> counts = new HashMap<>();
        for (final Person person : competition.getPersons()) {
            if (person.registration() == null) {
                continue;
            }

            for (final EventType event : person.registration().events()) {
                counts.put(event, counts.getOrDefault(event, 0) + 1);
            }
        }
        System.out.println(counts);
    }

}
