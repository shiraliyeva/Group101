package use_case.save_text;

public class SaveInteractor implements SaveInputBoundary {
    final SaveOutputBoundary saveOutputBoundary;

    final SaveDataAccessInterface saveDataAccessObject;

    public SaveInteractor(SaveDataAccessInterface saveDataAccessObject,
                          SaveOutputBoundary saveOutputBoundary) {
        this.saveOutputBoundary = saveOutputBoundary;
        this.saveDataAccessObject = saveDataAccessObject;
    }

    @Override
    public void execute(SaveInputData inputData) {
        String outputText = inputData.getText();
        SaveOutputData saveOutputData = new SaveOutputData(outputText);
        saveDataAccessObject.saveToPDF(outputText);
        this.saveOutputBoundary.prepareSaveView(saveOutputData);
    }
}