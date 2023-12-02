package interface_adapter.save_text;

import use_case.save_text.SaveInputBoundary;
import use_case.save_text.SaveInputData;

public class SaveController {
    final SaveInputBoundary saveInputBoundary;


    public SaveController(SaveInputBoundary saveInputBoundary) {
        this.saveInputBoundary = saveInputBoundary;
    }

    public void execute(String inputData) {
        SaveInputData saveInputData = new SaveInputData(inputData);
        saveInputBoundary.execute(saveInputData);


    }
}