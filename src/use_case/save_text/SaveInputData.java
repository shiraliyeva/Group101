package use_case.save_text;
import entity.Text;

public class SaveInputData {
    private final String text;

    public SaveInputData(String text){
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}