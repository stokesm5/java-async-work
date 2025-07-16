package taskmanager.models;

public enum Status {
    TODO("Todo"),
    IN_PROGRESS("In_progress"),
    COMPLETE("Completed");

    private String displayText;

    Status(String displayText){
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

}
