package use_case.save_text;

public class SaveInteractor implements SaveInputBoundary {
    final SaveOutputBoundary saveOutputBoundary;

    public SaveInteractor(SaveOutputBoundary saveOutputBoundary) {
        this.saveOutputBoundary = saveOutputBoundary;
    }

    @Override
    public void execute(SaveInputData inputData) {
        String outputText = inputData.getText();
        SaveOutputData saveOutputData = new SaveOutputData(outputText);
        this.saveOutputBoundary.prepareSaveView(saveOutputData);
    }
}