package webhelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class databaseManager {
    protected static String QUESTIONDELLIMITER="~~~~";
    protected static String CORRECTANSWERDELIM="++";
    protected static String USERNAME="root";
    protected static String PASS="kuchuxa123";
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
            boolean ord=rs.getBoolean(5);
            quiz temp=new quiz(quizName,userIduser.get(creatorId),quizId,new java.util.Date(creationDate.getTime()),ord);
            readQuizFromFile(temp,quizId);
            quizIdquiz.put(quizId,temp);
            userIduser.get(creatorId).addCreatedQuiz(temp);
        }
        rs.close();
        cn.close();
    }

    private void readQuizFromFile(quiz temp,int quizId) {
        String curDir=System.getProperty("user.dir");
        String dirName="quizQuestions";
        String curFile=quizId+".txt";
        File f=new File(curDir+File.separator+dirName+File.separator+curFile);
        if(f.exists()){
            try(BufferedReader rd=new BufferedReader(new FileReader(f))){
                String line;
                line=rd.readLine();
                temp.setDescription(line);
                while((line=rd.readLine())!=null){
                    int type=Integer.parseInt(line);
                    line=rd.readLine();
                    Question cur=new Question(line,type);
                    line=rd.readLine();
                    while(!line.equals(QUESTIONDELLIMITER)){
                        if(line.equals(CORRECTANSWERDELIM)){
                            line=rd.readLine();
                            cur.addCorrectAnswer(line);
                        }
                        else{
                            cur.addAnswer(line);
                        }
                        line=rd.readLine();
                    }
                    temp.addQuestion(cur);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

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
        String written="SELECT * FROM quizUser";
        ResultSet rs3=st.executeQuery(written);
        while(rs3.next()){
            int userId=rs3.getInt(1);
            int quizId=rs3.getInt(4);
            int score= rs3.getInt(2);
            userIduser.get(userId).addWrittenQuiz(quizIdquiz.get(quizId),score);
        }
        cn.close();
    }
}
