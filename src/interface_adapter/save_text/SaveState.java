package interface_adapter.save_text;

public class SaveState {
    private final boolean saveSuccessful;
    private final String errorMessage;

    public SaveState(boolean saveSuccessful, String errorMessage) {
        this.saveSuccessful = saveSuccessful;
        this.errorMessage = errorMessage;
    }

    public boolean isSaveSuccessful() {
        return saveSuccessful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}