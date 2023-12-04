package view.command;

import interface_adapter.ai_explanation.AiController;

public class AiCommand implements Command{
    private final AiController aiController;
    public String usersWord;
    public String suggestedWord;

    public AiCommand(AiController aiController, String usersWord, String suggestedWord) {
        this.aiController = aiController;
        this.usersWord = usersWord;
        this.suggestedWord = suggestedWord;
    }

    @Override
    public void execute() {
        aiController.execute(usersWord, suggestedWord);
    }

}
