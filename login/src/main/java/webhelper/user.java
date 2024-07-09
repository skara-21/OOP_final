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
    private String profileImageLink;
    public user(String username, int userId){
        this.username=username;
        this.userId=userId;
        quizzesCreated=new ArrayList<quiz>();
        friends=new ArrayList<user>();
        quizzesWritten=new ArrayList<quiz>();
        messages = new ArrayList<String>();
    }

    public void setProfilePic(String URL){
        userDatabase ud=new userDatabase();
        ud.insertProfilePic(userId,URL);
        profileImageLink=URL;
    }

    public String getProfilePic(){
        userDatabase ud=new userDatabase();
        String profURL=ud.getProfilePicdb(userId);
        if(profURL==null){
            return "https://i.pinimg.com/564x/c0/27/be/c027bec07c2dc08b9df60921dfd539bd.jpg";
        }else{
            return profURL;
        }
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
            userdb=new userDatabase();
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
        int score=0;//PLACEHOLDER
        float timeUsed=0;//PLACEHOLDER
        userDatabase ud=new userDatabase();
        ud.addWrittenQuizdb(userId,q.quizId,score,timeUsed);
        quizzesWritten.add(q);
    }

    public void createQuiz(quiz newQuiz){
        quizzesCreated.add(newQuiz);
        newQuiz.createFile();
        dbquiz=new quizDatabase();
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
        dbquiz=new quizDatabase();
        return dbquiz.getLastCreated(userId);
    }

    public ArrayList<quiz> getFeedInfoTaken(){
        dbquiz=new quizDatabase();
        return dbquiz.getLastTaken(userId);
    }

    public HashMap<Integer,Integer> getStatistics(){
        dbquiz=new quizDatabase();
        return dbquiz.getStatisticsdb(userId, true); //true anu vigeb useristvis
    }
    public void addMessage(String msg){
        messages.add(msg);
    }

}
