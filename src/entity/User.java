package entity;

import java.util.ArrayList;

public class User {


    private final String username;
    private final String password;
    private ArrayList<Text> saved_texts;

    public User(String username, String password, ArrayList<Text> savedTexts) {
        this.username = username;
        this.password = password;
        saved_texts = savedTexts;
    }
    public ArrayList<Text> getSaved_texts() {
        return saved_texts;
    }

    public void setSaved_texts(ArrayList<Text> saved_texts) {
        this.saved_texts = saved_texts;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}