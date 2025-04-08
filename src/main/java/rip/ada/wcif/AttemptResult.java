package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record AttemptResult(@JsonValue int value) {

    public boolean isSuccess() {
        return value > 0;
    }

    public boolean isSkipped() {
        return value == 0;
    }

    public boolean isDnf() {
        return value == -1;
    }

    public boolean isDns() {
        return value == -2;
    }

    public boolean isMbld() {
        return value > 10_000_000;
    }

    @Override
    public String toString() {
        if (isDnf()) {
            return "DNF";
        }
        if (isDns()) {
            return "DNS";
        }
        if (isSkipped()) {
            return "Skipped";
        }
        if (isMbld()) {
            final int missed = value % 100;
            final int time = value / 100 % 100000;
            final int difference = 99 - (value / 10_000_000);
            final int solved = difference + missed;
            final int attempted = solved + missed;

            return solved + "/" + attempted + " " + renderWithoutCentiseconds(time);
        }

        return renderTime(value);
    }

    private String renderTime(final int time) {
        final int centiseconds = time % 100;
        final int seconds = time / 100 % 60;
        final int minutes = time / 100 / 60 % 60;
        if (time < 100) {
            return "0." + time;
        }
        if (time < 6000) {
            return String.format("%d.%02d", seconds, centiseconds);
        }
        if (time < 60000) {
            return String.format("%d:%02d.%02d", minutes, seconds, centiseconds);
        }
        return renderWithoutCentiseconds(time / 100);
    }

    private String renderWithoutCentiseconds(final int time) {
        final int seconds = time % 60;
        final int minutes = time / 60 % 60;
        final int hours = time / 60 / 60;
        if (time < 3600) {
            return String.format("%d:%02d", minutes, seconds);
        }
        return String.format("%d:%02d:%02d", hours, minutes, seconds);
    }

    @JsonCreator
    public static AttemptResult fromInt(final int value) {
        return new AttemptResult(value);
    }

}
