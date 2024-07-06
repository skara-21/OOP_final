package webhelper;

import java.util.ArrayList;

public class Question {
    private String question;
    private int type;
    private ArrayList<String> answers;
    private String correctAnswer;

    public Question(String question, int type) {
        this.question = question;
        this.type = type;
        answers = new ArrayList<String>();
    }
    public void addCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addAnswer(String answer){
        answers.add(answer);
    }

    public String getQuestion() {
        return question;
    }
    public int getType() {
        return type;
    }
    public ArrayList<String> getAnswers() {
        return answers;
    }

}
