package rip.ada.wcif;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoundFormat {
    BEST_OF_ONE("1", "Best of 1", "Bo1", 1, "single", "average", 0, 0),
    BEST_OF_TWO("2", "Best of 2", "Bo2", 2, "single", "average", 0, 0, BEST_OF_ONE),
    BEST_OF_THREE("3", "Best of 3", "Bo3", 3, "single", "average", 0, 0, BEST_OF_ONE, BEST_OF_TWO),
    AVERAGE_OF_FIVE("a", "Average of 5", "Ao5", 5, "average", "single", 1, 1, BEST_OF_TWO),
    MEAN_OF_THREE("m", "Mean of 3", "Mo3", 3, "average", "single", 0, 0, BEST_OF_ONE, BEST_OF_TWO);

    private final String id;
    private final String name;
    private final String shortName;
    private final int solveCount;
    private final String sortBy;
    private final String sortBySecond;
    private final int trimSlowestN;
    private final int trimFastestN;
    private final RoundFormat[] allowedFirstPhaseFormats;

    RoundFormat(final String id,
                final String name,
                final String shortName,
                final int solveCount,
                final String sortBy,
                final String sortBySecond,
                final int trimSlowestN,
                final int trimFastestN,
                final RoundFormat... allowedFirstPhaseFormats) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.solveCount = solveCount;
        this.sortBy = sortBy;
        this.sortBySecond = sortBySecond;
        this.trimSlowestN = trimSlowestN;
        this.trimFastestN = trimFastestN;
        this.allowedFirstPhaseFormats = allowedFirstPhaseFormats;
    }

    @JsonValue
    public String getId() {
        return id;
    }

    @JsonCreator
    public static RoundFormat fromString(final String id) {
        for (final RoundFormat roundFormat : values()) {
            if (roundFormat.id.equals(id)) {
                return roundFormat;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public int getSolveCount() {
        return solveCount;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSortBySecond() {
        return sortBySecond;
    }

    public int getTrimSlowestN() {
        return trimSlowestN;
    }

    public int getTrimFastestN() {
        return trimFastestN;
    }

    public RoundFormat[] getAllowedFirstPhaseFormats() {
        return allowedFirstPhaseFormats;
    }
}
