package interface_adapter.ai_explanation;

public class AiState {
    private String explanation = "";

    public AiState(AiState copy) {
        explanation = copy.explanation;
    }

    public AiState(){}

    public String getExplanation(){
        return explanation;
    }

    public void setExplanation(String explanation){
        this.explanation = explanation;
    }

//    public String toString() {
//        return "AiState{" + "explanation=" + explanation'}';
//    }
}
