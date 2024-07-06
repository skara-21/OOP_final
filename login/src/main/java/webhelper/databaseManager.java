package webhelper;

import java.sql.*;
import java.util.HashMap;

public class databaseManager {
    protected static String USERNAME="root";
    protected static String PASS="SALOsalo123!";
    protected static String URL="jdbc:mysql://localhost:3306/University";
    protected HashMap<Integer,user> userIduser;
    protected HashMap<Integer,quiz> quizIdquiz;
    public databaseManager(){
        userIduser=new HashMap<Integer,user>();
        quizIdquiz=new HashMap<Integer,quiz>();
        try {
            createAllUsers();
            createAllQuizzes();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void createAllQuizzes() throws Exception{
        Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
        Statement st=cn.createStatement();
        String query="SELECT * FROM quiz";
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            int quizId=rs.getInt(1);
            String quizName=rs.getString(2);
            int creatorId=rs.getInt(3);
            Date creationDate=rs.getDate(4);
            String fileDest=rs.getString(5);
            //failis wakitxvis logika da kitxvebis sheqmnis
            quiz temp=new quiz(quizName,"hehe",userIduser.get(creatorId),quizId,new java.util.Date(creationDate.getTime()));
            quizIdquiz.put(quizId,temp);
            userIduser.get(creatorId).addCreatedQuiz(temp);
        }
        rs.close();
        cn.close();
    }

    private void createAllUsers() throws Exception {
        Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
        Statement st=cn.createStatement();
        String query="SELECT * FROM user";
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            int userId=rs.getInt(1);
            String username=rs.getString(2);
            user temp=new user(username,userId);
            userIduser.put(userId,temp);
        }
        rs.close();
        String friends="SELECT * FROM friends";
        ResultSet rs2=st.executeQuery(friends);
        while(rs2.next()){
            int userId=rs2.getInt(1);
            int friendId=rs2.getInt(2);
            String message=rs2.getString(3);
            userIduser.get(userId).addFriend(userIduser.get(friendId));
            userIduser.get(userId).addMessage(message);
        }
        cn.close();
    }
}
