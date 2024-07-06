package webhelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class quizDatabase extends databaseManager {
    private Statement st;

    public quizDatabase() throws Exception {
        Connection cn= DriverManager.getConnection(URL,USERNAME,PASS);
        st=cn.createStatement();
        //ResultSet rs=st.executeQuery("SELECT * FROM quiz");
        //st.executeUpdate("INSERT INTO lala lulu");
    }

    public ArrayList<quiz> getWrittenQuizzesById(int userId){
        if(userId<=0) return null;
        try {
            String stmnt = "SELECT * FROM quizUser LEFT JOIN quiz ON quiz.quizID=quizUser.quizID ";
            stmnt+="WHERE userID=" + userId;
            ResultSet rs=st.executeQuery(stmnt);
            while(rs.next()){

            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<quiz> getCreatedQuizesById(int userId) {
        return null;
    }

    public void add(quiz newQuiz) {
    }

    public ArrayList<quiz> getFeedInfodb(ArrayList<user> friends) {
        return null;
    }

    public HashMap<Integer, Integer> getStatisticsdb(int userId, boolean b) {
        return null;
    }

    public ArrayList<String> getLastPerformances(int userId, int quizId) {
        return null;
    }

    public ArrayList<String> getHighestPerformers(int quizId, boolean lastDay) {
        return null;
    }

    public ArrayList<String> getRecentTestTakers(int quizId) {
        return null;
    }
}
