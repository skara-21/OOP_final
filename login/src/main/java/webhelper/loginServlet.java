package webhelper;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    public loginServlet(){
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountManager db=(accountManager) request.getServletContext().getAttribute("MY_DB");
        if(db.correctCredentials(request.getParameter("username"),request.getParameter("pass"))){

            request.setAttribute("name", request.getParameter("username"));
            db.setAcc(request.getParameter("username"));
            RequestDispatcher tmp=request.getRequestDispatcher("HomePage.jsp");
            tmp.forward(request,response);

        }else{
            RequestDispatcher tmp=request.getRequestDispatcher("tryAgain.jsp");
            tmp.forward(request,response);
        }
    }
}
