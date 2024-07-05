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
            RequestDispatcher tmp=request.getRequestDispatcher("welcome.jsp");
            tmp.forward(request,response);
        }
        else{
            RequestDispatcher tmp=request.getRequestDispatcher("accNameInUse.jsp");
            tmp.forward(request,response);
        }
    }
}

