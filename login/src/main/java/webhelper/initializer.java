package webhelper;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class initializer implements ServletContextListener {
    public initializer(){
    }

    public void contextDestroyed(ServletContextEvent e){}

    public void contextInitialized(ServletContextEvent e){
        accountManager db=new accountManager();
        ServletContext tmp=e.getServletContext();
        tmp.setAttribute("MY_DB",db);

    }
}
