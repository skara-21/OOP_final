package webhelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class userDatabase extends databaseManager{
    public void addUser(String name, String pass) {
        String hashed=hashPassword(pass);
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st=cn.createStatement();
            String query="INSERT INTO user(userName,hashedPass) VALUES ('"+name+"' , '"+hashed+"')";
            int inserted=st.executeUpdate(query);
            if(inserted<=0){
                System.out.println("That didn't work");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private String hashPassword(String pass) {
        try {
            MessageDigest hasher = MessageDigest.getInstance("SHA");
            hasher.update(pass.getBytes());
            return hexToString(hasher.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String hexToString(byte[] bytes) {
        StringBuffer buff = new StringBuffer();
        for (int i=0; i<bytes.length; i++) {
            int val = bytes[i];
            val = val & 0xff;  // remove higher bits, sign
            if (val<16) buff.append('0'); // leading 0
            buff.append(Integer.toString(val, 16));
        }
        return buff.toString();
    }

    public user searchAccontByName(String name) {
        for(int id: userIduser.keySet()){
            if(userIduser.get(id).username.equals(name)){
                return userIduser.get(id);
            }
        }
        return null;
    }
    public void addFrienddb(int userId,int friendId){
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st = cn.createStatement();
            String query="INSERT INTO friends (userID,friendID) VALUES ('"+userId+"', '"+friendId+"')";
            int tot=st.executeUpdate(query);
            if(tot<=0){
                System.out.println("That didn't work");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addWrittenQuizdb(int userID,int quizID,int score,float timeUsed){
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            java.sql.Date dt=new java.sql.Date(quizIdquiz.get(quizID).creationDate.getTime());
            String query="INSERT INTO quizUser (userID, score, timeUsed, quizID, dateTaken) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps=cn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, score);
            ps.setFloat(3, timeUsed);
            ps.setInt(4, quizID);
            ps.setDate(5, dt);
            int tot=ps.executeUpdate(query);
            if(tot<=0){
                System.out.println("quiz wasn't inserted in the database");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean isCorrectPass(user usr, String pass) {
        String hashedPass=hashPassword(pass);
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st = cn.createStatement();
            String query="SELECT hashedPass FROM user WHERE userID="+usr.userId;
            ResultSet rs=st.executeQuery(query);
            if (rs.next()){
                String actual=rs.getString("hashedPass");
                rs.close();
                cn.close();
                if(actual.equals(hashedPass)){
                    return true;
                }
                else {
                    return false;
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getProfilePicdb(int userId) {
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st = cn.createStatement();
            String query="SELECT profImageLink FROM user WHERE userID="+userId;
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
                return rs.getString("profImageLink");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void insertProfilePic(int userId, String url) {
        try {
            Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement st = cn.createStatement();
            String query="UPDATE user SET profImageLink='"+url+"' WHERE userID= "+userId;
            int rows=st.executeUpdate(query);
            if(rows<=0){
                System.out.println("Profile link wasn't set");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
