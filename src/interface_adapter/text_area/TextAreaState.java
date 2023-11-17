package interface_adapter.text_area;

public class TextAreaState {
    private String textContent = "";
    public TextAreaState(TextAreaState copy){
        textContent = copy.textContent;
    }

    public TextAreaState(){
    }

    public String getTextContent(){
        return textContent;
    }

}