package rip.ada.wcif.examples;

import rip.ada.wcif.Activity;
import rip.ada.wcif.ActivityCode;
import rip.ada.wcif.Competition;
import rip.ada.wcif.Event;
import rip.ada.wcif.Room;
import rip.ada.wcif.Round;
import rip.ada.wcif.Venue;

import java.time.Duration;
import java.util.List;

import static rip.ada.wcif.examples.util.GetWcif.getCompetitionById;

public class CreateGroups {

    public static void main(final String[] args) {
        final Competition competition = getCompetitionById("BristolSquockDay2024");
        for (final Venue venue : competition.getSchedule().getVenues()) {
            for (final Room room : venue.getRooms()) {
                for (final Activity activity : room.activities()) {
                    if (!activity.getActivityCode().event().isCompetingEvent()) {
                        continue;
                    }

                    final int scrambleSets = getScrambleSets(competition, activity.getActivityCode());

                    final Duration activityDuration = Duration.between(activity.getStartTime(), activity.getEndTime());
                    final Duration groupDuration = activityDuration.dividedBy(scrambleSets);

                    for (int i = 0; i < scrambleSets; i++) {
                        final ActivityCode activityCode = new ActivityCode(activity.getActivityCode().event(), activity.getActivityCode().round(), i, null);
                        activity.getChildActivities().add(
                                new Activity(
                                        getHighestActivityCode(competition),
                                        activityCode.getDisplayName(),
                                        activityCode,
                                        activity.getStartTime().plus(groupDuration.multipliedBy(i)),
                                        activity.getStartTime().plus(groupDuration.multipliedBy(i + 1)),
                                        List.of(),
                                        null,
                                        List.of()
                                ));
                    }
                }
            }
        }
        System.out.println(competition);
    }

    private static int getHighestActivityCode(final Competition competition) {
        int max = 0;
        for (final Venue venue : competition.getSchedule().getVenues()) {
            for (final Room room : venue.getRooms()) {
                for (final Activity activity : room.activities()) {
                    max = Math.max(max, getHighestActivityCodeFromActivity(activity));
                }
            }
        }
        return max;
    }

    private static int getHighestActivityCodeFromActivity(final Activity activity) {
        int max = activity.getId();
        for (final Activity childActivity : activity.getChildActivities()) {
            max = Math.max(max, getHighestActivityCodeFromActivity(childActivity));
        }
        return max;
    }

    private static int getScrambleSets(final Competition competition, final ActivityCode activityCode) {
        for (final Event event : competition.getEvents()) {
            if (event.eventType() != activityCode.event()) {
                continue;
            }

            for (final Round round : event.rounds()) {
                if (round.event() == activityCode.event() && round.roundNumber().equals(activityCode.round())) {
                    return round.scrambleSetCount();
                }
            }
        }
        return 0;
    }

}
