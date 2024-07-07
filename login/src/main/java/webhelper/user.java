package webhelper;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;

public class user {
    private static int XPINLVL=10;
    public String username;
    public int userId;
    private ArrayList<quiz> quizzesCreated;
    private ArrayList<user> friends;
    private ArrayList<quiz> quizzesWritten;
    private quizDatabase dbquiz;
    private userDatabase userdb;
    private ArrayList<String> messages;
    public user(String username, int userId){
        this.username=username;
        this.userId=userId;
        quizzesCreated=new ArrayList<quiz>();
        friends=new ArrayList<user>();
        quizzesWritten=new ArrayList<quiz>();
        messages = new ArrayList<String>();
        dbquiz=new quizDatabase();
        userdb=new userDatabase();
    }

    public ArrayList<quiz> getWrittenQuizzes(){
        return quizzesWritten;
    }

    public ArrayList<quiz> getCreatedQuizzes(){
        return quizzesCreated;
    }

    public void addFriend(user newFriend){
        if(!friends.contains(newFriend)) {
            friends.add(newFriend);
            newFriend.addFriend(this);
            userdb.addFrienddb(userId, newFriend.userId);
        }
    }

    public ArrayList<user> getFriendList(){
        return friends;
    }

    public void addCreatedQuiz(quiz q){
        quizzesCreated.add(q);
    }

    public void addWrittenQuiz(quiz q){
        quizzesWritten.add(q);
    }

    public void createQuiz(quiz newQuiz){
        quizzesCreated.add(newQuiz);
        newQuiz.createFile();
        dbquiz.add(newQuiz);
    }

    public int getlevel(){
        int tot=(int)(quizzesCreated.size()*4 + (quizzesWritten.size())*2);
        //tito sheqmnili qvizi=4xp tito dawerili qvizi=2xp
        return tot-(tot)%XPINLVL;
    }

    public int getXp(){
        int tot=(int)(quizzesCreated.size()*4 + (quizzesWritten.size())*2);
        //tito sheqmnili qvizi=4xp tito dawerili qvizi=2xp
        return (tot)%XPINLVL;
    }


    public ArrayList<quiz> getFeedInfoCreated(){
        return dbquiz.getLastCreated(userId);
    }

    public ArrayList<quiz> getFeedInfoTaken(){
        return dbquiz.getLastTaken(userId);
    }

    public HashMap<Integer,Integer> getStatistics(){
        return dbquiz.getStatisticsdb(userId, true); //true anu vigeb useristvis
    }
    public void addMessage(String msg){
        messages.add(msg);
    }

}
