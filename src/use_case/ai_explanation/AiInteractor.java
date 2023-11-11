package use_case.ai_explanation;

public class AiInteractor implements AiInputBoundary {
    private final AiDataAccessInterface aiDataAccessObject;
    private final AiOutputBoundary aiOutputBoundary;

    public AiInteractor(AiDataAccessInterface aiDataAccessObject, AiOutputBoundary aiOutputBoundary) {
        this.aiDataAccessObject = aiDataAccessObject;
        this.aiOutputBoundary = aiOutputBoundary;
    }

    @Override
    public void execute(AiInputData aiInputData) {
        // Business logic for AI explanation
        String usersWord = aiInputData.getUsersWord();
        String suggestedWord = aiInputData.getSuggestedWord();

        // Call the API through the data access object
        String explanationFromApi = aiDataAccessObject.getAiExplanation(usersWord, suggestedWord);

        AiOutputData aiOutputData = new AiOutputData(explanationFromApi);
        aiOutputBoundary.prepareView(aiOutputData);
    }
}
