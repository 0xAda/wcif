package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Activity {

    private int id;
    private String name;
    private ActivityCode activityCode;
    private Instant startTime;
    private Instant endTime;
    private List<Activity> childActivities;
    private Integer scrambleSetId;
    private List<Extension> extensions;

    public Activity(final @JsonProperty("id") int id,
                    final @JsonProperty("name") String name,
                    final @JsonProperty("activityCode") ActivityCode activityCode,
                    final @JsonProperty("startTime") @JsonFormat(shape = JsonFormat.Shape.STRING) Instant startTime,
                    final @JsonProperty("endTime") @JsonFormat(shape = JsonFormat.Shape.STRING) Instant endTime,
                    final @JsonProperty("childActivities") List<Activity> childActivities,
                    final @JsonProperty("scrambleSetId") Integer scrambleSetId,
                    final @JsonProperty("extensions") List<Extension> extensions) {
        this.id = id;
        this.name = name;
        this.activityCode = activityCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.childActivities = childActivities;
        this.scrambleSetId = scrambleSetId;
        this.extensions = extensions;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ActivityCode getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(final ActivityCode activityCode) {
        this.activityCode = activityCode;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(final Instant startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(final Instant endTime) {
        this.endTime = endTime;
    }

    public List<Activity> getChildActivities() {
        return childActivities;
    }

    public void setChildActivities(final List<Activity> childActivities) {
        this.childActivities = childActivities;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getScrambleSetId() {
        return scrambleSetId;
    }

    public void setScrambleSetId(final Integer scrambleSetId) {
        this.scrambleSetId = scrambleSetId;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(final List<Extension> extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Activity activity = (Activity) object;
        return id == activity.id &&
                Objects.equals(name, activity.name) &&
                Objects.equals(activityCode, activity.activityCode) &&
                Objects.equals(startTime, activity.startTime) &&
                Objects.equals(endTime, activity.endTime) &&
                Objects.equals(childActivities, activity.childActivities) &&
                Objects.equals(scrambleSetId, activity.scrambleSetId) &&
                Objects.equals(extensions, activity.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, activityCode, startTime, endTime, childActivities, scrambleSetId, extensions);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activityCode=" + activityCode +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", childActivities=" + childActivities +
                ", scrambleSetId=" + scrambleSetId +
                ", extensions=" + extensions +
                '}';
    }
}
