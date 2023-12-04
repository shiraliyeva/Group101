package view.command;

import interface_adapter.clear_text.ClearController;

public class ClearCommand implements Command {
    private final ClearController clearController;

    public ClearCommand(ClearController clearController) {
        this.clearController = clearController;
    }

    @Override
    public void execute() {
        clearController.execute();
    }
}