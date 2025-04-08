package rip.ada.wcif.examples;

import rip.ada.wcif.Competition;
import rip.ada.wcif.Gender;
import rip.ada.wcif.Person;

import java.util.HashMap;
import java.util.Map;

import static rip.ada.wcif.examples.util.GetWcif.getCompetitionById;

public class GenderSplit {

    public static void main(final String[] args) {
        final Competition competition = getCompetitionById("RubiksUKChampionship2024");
        final Map<Gender, Integer> counts = new HashMap<>();
        for (final Person person : competition.getPersons()) {
            counts.put(person.gender(), counts.getOrDefault(person.gender(), 0) + 1);
        }

        System.out.println(counts);
    }

}
