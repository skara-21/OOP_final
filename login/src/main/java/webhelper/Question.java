package webhelper;

import java.util.ArrayList;

public class Question {
    private String question;
    private int type;
    public ArrayList<String> answers;
    private ArrayList<String> correctAnswer;

    private String corAns;

    public Question(String question, int type) {
        this.question = question;
        this.type = type;
        answers = new ArrayList<String>();
        correctAnswer=new ArrayList<String>();
    }
    public void addCorrectAnswer(String correctAns) {
            corAns=correctAns;
    }

    public void addAnswer(String answer){
        answers.add(answer);
    }
    public String getCorrectAnswer(){
        return corAns;
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
