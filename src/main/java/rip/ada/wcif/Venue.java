package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public final class Venue {
    private int id;
    private String name;
    private int latitudeMicroDegrees;
    private int longitudeMicroDegrees;
    private CountryCode country;
    private String timezone;
    private List<Room> rooms;
    private List<Extension> extensions;

    public Venue(
            final @JsonProperty("id") int id,
            final @JsonProperty("name") String name,
            final @JsonProperty("latitudeMicrodegrees") int latitudeMicroDegrees,
            final @JsonProperty("longitudeMicrodegrees") int longitudeMicroDegrees,
            final @JsonProperty("countryIso2") CountryCode country,
            final @JsonProperty("timezone") String timezone,
            final @JsonProperty("rooms") List<Room> rooms,
            final @JsonProperty("extensions") List<Extension> extensions
    ) {
        this.id = id;
        this.name = name;
        this.latitudeMicroDegrees = latitudeMicroDegrees;
        this.longitudeMicroDegrees = longitudeMicroDegrees;
        this.country = country;
        this.timezone = timezone;
        this.rooms = rooms;
        this.extensions = extensions;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("latitudeMicrodegrees")
    public int getLatitudeMicroDegrees() {
        return latitudeMicroDegrees;
    }

    @JsonProperty("longitudeMicrodegrees")
    public int getLongitudeMicroDegrees() {
        return longitudeMicroDegrees;
    }

    @JsonProperty("countryIso2")
    public CountryCode getCountry() {
        return country;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("rooms")
    public List<Room> getRooms() {
        return rooms;
    }

    @JsonProperty("extensions")
    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setLatitudeMicroDegrees(final int latitudeMicroDegrees) {
        this.latitudeMicroDegrees = latitudeMicroDegrees;
    }

    public void setLongitudeMicroDegrees(final int longitudeMicroDegrees) {
        this.longitudeMicroDegrees = longitudeMicroDegrees;
    }

    public void setCountry(final CountryCode country) {
        this.country = country;
    }

    public void setTimezone(final String timezone) {
        this.timezone = timezone;
    }

    public void setRooms(final List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setExtensions(final List<Extension> extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final Venue that = (Venue) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                this.latitudeMicroDegrees == that.latitudeMicroDegrees &&
                this.longitudeMicroDegrees == that.longitudeMicroDegrees &&
                Objects.equals(this.country, that.country) &&
                Objects.equals(this.timezone, that.timezone) &&
                Objects.equals(this.rooms, that.rooms) &&
                Objects.equals(this.extensions, that.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitudeMicroDegrees, longitudeMicroDegrees, country, timezone, rooms, extensions);
    }

    @Override
    public String toString() {
        return "Venue[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "latitudeMicroDegrees=" + latitudeMicroDegrees + ", " +
                "longitudeMicroDegrees=" + longitudeMicroDegrees + ", " +
                "country=" + country + ", " +
                "timezone=" + timezone + ", " +
                "rooms=" + rooms + ", " +
                "extensions=" + extensions + ']';
    }

}
