package webhelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class quizDatabase extends databaseManager {

    public quizDatabase() {
    }

    public ArrayList<quiz> getWrittenQuizzesById(int userId){
        if(userId<=0) return null;
        return userIduser.get(userId).getWrittenQuizzes();
    }

    public ArrayList<quiz> getCreatedQuizesById(int userId) {
        if(userId<=0) return null;
        return userIduser.get(userId).getCreatedQuizzes();
    }

    public void add(quiz newQuiz) {
        java.sql.Date dt=new java.sql.Date(newQuiz.creationDate.getTime());
        String query = "INSERT INTO quiz (quizName, creatorID, creationDate, orderedRandom) VALUES (?, ?, ?, ?)";
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            PreparedStatement ps=cn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,newQuiz.quizName);
            ps.setInt(2,newQuiz.creator.userId);
            ps.setDate(3,dt);
            ps.setBoolean(4,newQuiz.ordRand);
            int test=ps.executeUpdate();
            if(test<=0){
                System.out.println("That didn't work");
            }
            try (ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    newQuiz.quizId=rs.getInt(1);
                }
            }
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public HashMap<Integer, Integer> getStatisticsdb(int Id, boolean forUser) {
        HashMap<Integer,Integer> ans=new HashMap<Integer,Integer>();
        if(forUser){
            String query="SELECT score, COUNT(*) AS times_scored FROM quizUser WHERE userID = "+Id+" GROUP BY score ORDER BY score";
            try {
                Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){
                    int score=rs.getInt("score");
                    int freq=rs.getInt("times_scored");
                    ans.put(score,freq);
                }
                cn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else {
            String query="SELECT score, COUNT(*) AS times_scored FROM quizUser WHERE quizID = "+Id+" GROUP BY score ORDER BY score";
            try {
                Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){
                    int score=rs.getInt("score");
                    int freq=rs.getInt("times_scored");
                    ans.put(score,freq);
                }
                cn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return ans;
    }

    public ArrayList<String> getLastPerformances(int userId, int quizId) {
        ArrayList<String> ans=new ArrayList<String>();
        String query="SELECT dateTaken, score,timeUsed FROM quizUser WHERE quizId="+quizId+" AND userId="+userId;
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Date dt=rs.getDate("dateTaken");
                int score=rs.getInt("score");
                float timeUsed=rs.getFloat("timeUsed");
                String det="On "+dt.toString()+" you scored "+score+"points in"+timeUsed+"minutes";
                ans.add(det);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return ans;
    }

    public ArrayList<String> getHighestPerformers(int quizId, boolean lastDay) {
        ArrayList<String > ans=new ArrayList<String>();
        String query="";
        if(lastDay) {
                query = "SELECT userID,score,timeUsed FROM quizUser WHERE quizID = " + quizId
                    + "AND dateTaken >= CURDATE() - INTERVAL 1 DAY AND dateTaken < CURDATE() + INTERVAL 1 DAY "
                    + "ORDER BY score DESC";
        }else{
                query = "SELECT userID,score,timeUsed FROM quizUser WHERE quizID = " + quizId
                    + " ORDER BY score DESC";
        }
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int userdId = rs.getInt("userID");
                String usernm = userIduser.get(userdId).username;
                int score = rs.getInt("score");
                float timeused = rs.getFloat("timeUsed");
                String str = usernm + " scored " + score + " in " + timeused + " minutes";
                ans.add(str);
                if (ans.size() == 3) {
                    break;
                }
            }
            rs.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    public ArrayList<String> getRecentTestTakers(int quizId) {
        ArrayList<String > ans=new ArrayList<String>();
        String query = "SELECT userID,score,timeUsed FROM quizUser WHERE quizID = " + quizId
                + "AND dateTaken >= CURDATE() - INTERVAL 1 DAY AND dateTaken < CURDATE() + INTERVAL 1 DAY "
                + "ORDER BY dateTaken DESC";
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int userdId = rs.getInt("userID");
                String usernm = userIduser.get(userdId).username;
                int score = rs.getInt("score");
                float timeused = rs.getFloat("timeUsed");
                String str = usernm + " scored " + score + " in " + timeused + " minutes";
                ans.add(str);
                if (ans.size() == 5) {
                    break;
                }
            }
            rs.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    public quiz getQuizById(int quizId) {
        return quizIdquiz.get(quizId);
    }

    public ArrayList<quiz> getLastCreated(int userId) {
        ArrayList<quiz> ans=new ArrayList<quiz>();
        String query="SELECT q.quizID, q.creationDate" +
                "FROM quiz q" +
                "JOIN friends f ON q.creatorID = f.friendID" +
                "WHERE f.userID = " +userId+
                "ORDER BY q.creationDate DESC" +
                "LIMIT 3;";
        try{
            Connection cn=DriverManager.getConnection(URL,USERNAME,PASS);
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("quizID");
                ans.add(quizIdquiz.get(id));
            }
            rs.close();
            cn.close();
        }catch (Exception E){
            E.printStackTrace();
        }
        return ans;
    }

    public ArrayList<quiz> getLastTaken(int userId) {
        ArrayList<quiz> ans=new ArrayList<quiz>();
        String query="SELECT q.quizID, qu.dateTaken" +
                "FROM quizUser qu" +
                "JOIN quiz q ON qu.quizID = q.quizID" +
                "JOIN friends f ON qu.userID = f.friendID" +
                "WHERE f.userID = "+ userId+
                " ORDER BY qu.dateTaken DESC" +
                "LIMIT 3;";
        try{
            Connection cn=DriverManager.getConnection(URL,USERNAME,PASS);
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("quizID");
                ans.add(quizIdquiz.get(id));
            }
            rs.close();
            cn.close();
        }catch (Exception E){
            E.printStackTrace();
        }
        return ans;
    }

    public ArrayList<quiz> getPopularQuizzesdb() {
        ArrayList<quiz> ans=new ArrayList<quiz>();
        String query="SELECT q.quizID, q.quizName, COUNT(qu.quizID) AS takenCount" +
                "FROM quiz q" +
                "JOIN quizUser qu ON q.quizID = qu.quizID" +
                "GROUP BY q.quizID, q.quizName" +
                "ORDER BY takenCount DESC" +
                "ORDER BY takenCount DESC" +
                "LIMIT 3;";
        try{
            Connection cn=DriverManager.getConnection(URL,USERNAME,PASS);
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("quizID");
                ans.add(quizIdquiz.get(id));
            }
            rs.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    public ArrayList<quiz> getRecentQuizzesdb() {
        ArrayList<quiz> ans=new ArrayList<quiz>();
        String query="SELECT quizID " +
                "FROM quiz" +
                "ORDER BY creationDate DESC" +
                "LIMIT 3;";
        try{
            Connection cn=DriverManager.getConnection(URL,USERNAME,PASS);
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("quizID");
                ans.add(quizIdquiz.get(id));
            }
            rs.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }
}
