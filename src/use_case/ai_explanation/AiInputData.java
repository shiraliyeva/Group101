package use_case.ai_explanation;

public class AiInputData {
    private String usersWord;
    private String suggestedWord;

    public AiInputData(String usersWord, String suggestedWord) {
        this.usersWord = usersWord;
        this.suggestedWord = suggestedWord;
    }

    String getUsersWord(){
        return usersWord;
    }

    String getSuggestedWord(){
        return suggestedWord;
    }
}
