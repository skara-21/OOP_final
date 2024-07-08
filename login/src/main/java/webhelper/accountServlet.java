package webhelper;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/accountServlet")
public class accountServlet extends HttpServlet {
    public accountServlet(){
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountManager db=(accountManager) request.getServletContext().getAttribute("MY_DB");


        if(!db.accountExists(request.getParameter("username"))){
            db.createAcc(request.getParameter("username"),request.getParameter("pass"));
            userDatabase udb = (userDatabase) request.getServletContext().getAttribute("MY_DB2");
            String username = (String) request.getParameter("username");
            String pass = (String) request.getParameter("pass");

            db.createAcc(username, pass);
            udb.addUser(username, pass);

            request.setAttribute("username", username);
            RequestDispatcher tmp=request.getRequestDispatcher("HomePage.jsp");
            tmp.forward(request,response);

        }
        else{
            String username = (String) request.getParameter("username");
            request.setAttribute("username", username);
            RequestDispatcher tmp=request.getRequestDispatcher("accNameInUse.jsp");
            tmp.forward(request,response);
        }
    }
}

