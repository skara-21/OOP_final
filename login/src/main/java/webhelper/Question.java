package webhelper;

import java.util.ArrayList;

public class Question {
    public String question;
    public int type;
    public ArrayList<String> answers;
    public Question(String question, int type, ArrayList<String>answers) {
        this.question = question;
        this.type = type;
        this.answers = answers;
    }

    public int getType() {
        return type;
    }

}
