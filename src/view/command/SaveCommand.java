package view.command;

import interface_adapter.save_text.SaveController;

import javax.swing.*;

public class SaveCommand implements Command {
    private final SaveController saveController;
    public String text;

    public SaveCommand(SaveController saveController, String text) {
        this.saveController = saveController;
        this.text = text;
    }

    @Override
    public void execute() {
        saveController.execute(text);
    }

}