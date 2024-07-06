package webhelper;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class initializer implements ServletContextListener {
    public initializer(){
    }

    private quizDatabase quizDatabase;
    public void contextDestroyed(ServletContextEvent e){}

    public void contextInitialized(ServletContextEvent e){
        accountManager db=new accountManager();
        ServletContext tmp=e.getServletContext();
        tmp.setAttribute("MY_DB",db);

        try {
            quizDatabase = new quizDatabase(); // Initialize your quiz database
            tmp.setAttribute("QUIZ_DATABASE", quizDatabase);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }


}
