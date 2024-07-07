package webhelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class quiz {
    protected static String QUESTIONDELLIMITER="~~~~";
    protected static String CORRECTANSWERDELIM="++";
    public String quizName;
    public String description;
    public user creator;
    public int quizId;
    public Date creationDate;
    private ArrayList<Question> questions;
    private quizDatabase dbquiz;
    public boolean ordRand;


   public quiz(String quizName,user creator,int quizId,Date creationDate,boolean ordRand){
       this.questions = new ArrayList<Question>();
       this.quizId=quizId;
       this.quizName=quizName;
       this.creator=creator;
       this.creationDate=creationDate;
       this.ordRand=ordRand;
       dbquiz=new quizDatabase();
   }

   public void setDescription(String desc){
       description=desc;
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

   public void addQuestion(Question question) {
       questions.add(question);
   }

    public void createFile() {
        String curDir=System.getProperty("user.dir");
        String dirName="quizQuestions";
        String curFile=quizId+".txt";
        File f=new File(curDir+File.separator+dirName+File.separator+curFile);
        try {
            BufferedWriter zurabi = new BufferedWriter(new FileWriter(f));
            zurabi.write(description);
            zurabi.write("\n");
            for(int i=0;i<questions.size();i++){
                Question kit=questions.get(i);
                zurabi.write(kit.getType());
                zurabi.write("\n");
                zurabi.write(kit.getQuestion());
                zurabi.write("\n");
                if(kit.getAnswers().size()>0){
                    for(int j=0;j<kit.getAnswers().size();j++){
                        zurabi.write(kit.getAnswers().get(j));
                        zurabi.write("\n");
                    }
                }
                zurabi.write(CORRECTANSWERDELIM);
                zurabi.write("\n");
                zurabi.write(kit.getCorrectAnswer());
                zurabi.write("\n");
                zurabi.write(QUESTIONDELLIMITER);
                zurabi.write("\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
