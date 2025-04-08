package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class Schedule {
    private LocalDate startDate;
    private int numberOfDays;
    private List<Venue> venues;

    public Schedule(
            final @JsonProperty("startDate") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate startDate,
            final @JsonProperty("numberOfDays") int numberOfDays,
            final @JsonProperty("venues") List<Venue> venues
    ) {
        this.startDate = startDate;
        this.numberOfDays = numberOfDays;
        this.venues = venues;
    }

    @JsonProperty("startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getStartDate() {
        return startDate;
    }

    @JsonProperty("numberOfDays")
    public int getNumberOfDays() {
        return numberOfDays;
    }

    @JsonProperty("venues")
    public List<Venue> getVenues() {
        return venues;
    }

    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setNumberOfDays(final int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setVenues(final List<Venue> venues) {
        this.venues = venues;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final Schedule that = (Schedule) obj;
        return Objects.equals(this.startDate, that.startDate) &&
                this.numberOfDays == that.numberOfDays &&
                Objects.equals(this.venues, that.venues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, numberOfDays, venues);
    }

    @Override
    public String toString() {
        return "Schedule[" +
                "startDate=" + startDate + ", " +
                "numberOfDays=" + numberOfDays + ", " +
                "venues=" + venues + ']';
    }

}
