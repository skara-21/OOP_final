package webhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class accountManager {
    private Map<String,String> accountPass;
    private user currUser;
    private quiz currQuiz;
    private userDatabase db;
    public int curQuestionIndex;
    public int score;
    public accountManager(){
            this.accountPass = new HashMap<>();
            db = new userDatabase();
            curQuestionIndex=0;
            score = 0;
    }

    public void setAcc(String username){
        currUser = db.searchAccontByName(username);
    }
    public void setCurrQuiz(quiz z){currQuiz=z;}
    public quiz getCurrQuiz(){return currQuiz;}

    public void createAcc(String name,  String pass){
        currUser = new user(name, 0);
        db.addUser(name, pass);
    }

    public user getCurrUser(){
        return currUser;
    }
    public ArrayList<quiz> newsFeedCreated(){
        return currUser.getFeedInfoCreated();
    }
    public ArrayList<quiz> newsFeedTaken(){return currUser.getFeedInfoTaken(); }

    public boolean accountExists(String name){
        user usr=db.searchAccontByName(name);
        if(usr!=null){
            return true;
        }

        return false;
    }
    public boolean correctCredentials(String name,String Pass){
        user usr=db.searchAccontByName(name);

        if(usr!=null){
            if(db.isCorrectPass(usr,Pass)) return true;
            else return false;
        }
        return false;
    }

    public user searchAccountByName(String name){
        return db.searchAccontByName(name);
    }


}
