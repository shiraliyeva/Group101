package use_case.save_text;

public class SaveOutputData {
    private final String outputText;

    public SaveOutputData(String outputText) {
        this.outputText = outputText;
    }

    public String getOutputText(){
        return outputText;
    }
}
