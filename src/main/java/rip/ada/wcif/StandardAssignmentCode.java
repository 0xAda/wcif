package rip.ada.wcif;

public enum StandardAssignmentCode implements AssignmentCode {
    // WCIF specified codes
    COMPETITOR("competitor"),
    JUDGE("staff-judge"),
    SCRAMBLER("staff-scrambler"),
    RUNNER("staff-runner"),
    DATA_ENTRY("staff-dataentry"),
    ANNOUNCER("staff-announcer"),
    // https://github.com/coder13/Competitor-groups/blob/main/src/lib/assignments.ts
    DELEGATE("staff-delegate"),
    STAGE_LEAD("staff-stagelead"),
    SHOW_RUNNER("staff-showrunner"),
    LUNCH("staff-lunch"),
    BREAK("staff-break"),
    CORE("staff-core"),
    SETUP_TEARDOWN("staff-setupteardown"),
    OTHER("staff-other");

    private final String code;

    StandardAssignmentCode(final String code) {
        this.code = code;
    }

    @Override
    public String asString() {
        return code;
    }
}
