package webhelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class quiz {
    public String quizName;
    public String description;
    public user creator;
    private int quizId;

   public quiz(String quizName,String description,user creator,int quizId){
       this.quizId=quizId;
       this.quizName=quizName;
       this.description=description;
       this.creator=creator;
   }
   public ArrayList<String> usersLastPerformances(int userId){
        return  dbquiz.getLastPerformances(userId,quizId);
   }

   public ArrayList<String> getHighestPerformers(boolean lastDay){
       return dbquiz.getHighestPerformers(quizId,lastDay);
   }

   public ArrayList<String> getRecentTestTakers(){
       return dbquiz.getRecentTestTakers(quizId);
   }

   public HashMap<Integer,Integer> getStatistics(){
       return dbquiz.getStatisticsdb(quizId,false); //false anu vigeb qvizistvis
   }

}
