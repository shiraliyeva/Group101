package interface_adapter.ai_explanation;

import use_case.ai_explanation.AiInputBoundary;
import use_case.ai_explanation.AiInputData;
import view.TextAreaView;

public class AiController {
    final AiInputBoundary responseAiUseCaseInteractor;
    public AiController(AiInputBoundary responseAiUseCaseInteractor) {
        this.responseAiUseCaseInteractor = responseAiUseCaseInteractor;
    }

    public void execute(String usersWord, String suggestedWord) {
        AiInputData aiInputData = new AiInputData(
                usersWord, suggestedWord);

        responseAiUseCaseInteractor.execute(aiInputData);
    }

}
