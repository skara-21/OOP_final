package webhelper;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

@WebListener
public class initializer implements ServletContextListener {
    public initializer(){
    }

    private quizDatabase quizDatabase;
    public void contextDestroyed(ServletContextEvent e){}

    public void contextInitialized(ServletContextEvent e){
        accountManager db=new accountManager();
        databaseManager dm=new databaseManager();
        userDatabase udb = new userDatabase();

        ServletContext tmp=e.getServletContext();
        tmp.setAttribute("MY_DB",db);
        tmp.setAttribute("MY_DB2",udb);
        tmp.setAttribute("Dm",dm);

        try {
            quizDatabase = new quizDatabase(); // Initializing quiz database
            tmp.setAttribute("QUIZ_DATABASE", quizDatabase);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }



    }


}
