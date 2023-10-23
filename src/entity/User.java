package entity;

import java.util.ArrayList;

public class User {


    private final String username;
    private final String password;
    private ArrayList<InputText> saved_texts;

    public User(String username, String password, ArrayList<InputText> savedTexts) {
        this.username = username;
        this.password = password;
        saved_texts = savedTexts;
    }
    public ArrayList<InputText> getSaved_texts() {
        return saved_texts;
    }

    public void setSaved_texts(ArrayList<InputText> saved_texts) {
        this.saved_texts = saved_texts;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
