package webhelper;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;

public class user {
    private static int XPINLVL=10;
    public String username;
    private int userId;
    private ArrayList<quiz> quizzesCreated;
    private ArrayList<user> friends;
    private ArrayList<quiz> quizzesWritten;
    private quizDatabase dbquiz;
    private friendsDatabase dbfriends;
    public user(String username, int userId){
        this.username=username;
        this.userId=userId;
        quizzesCreated=new ArrayList<quiz>();
        friends=new ArrayList<user>();
        quizzesWritten=new ArrayList<quiz>();
    }

    public ArrayList<quiz> getWrittenQuizzes(){
        return quizzesWritten;
    }

    public ArrayList<quiz> getCreatedQuizzes(){
        return quizzesCreated;
    }

    public void addFriend(user newFriend){
        friends.add(newFriend);
        newFriend.addFriend(this);
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

    //qvizis baza join qvizi+user quiz_id=quiz_id

    public ArrayList<quiz> getFeedInfo(){
        return dbquiz.getFeedInfodb(friends);
    }

    public HashMap<Integer,Integer> getStatistics(){
        return dbquiz.getStatisticsdb(userId, true); //true anu vigeb useristvis
    }

}
