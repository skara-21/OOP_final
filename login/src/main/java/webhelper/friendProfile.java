package webhelper;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/friendProfile")
public class friendProfile extends HttpServlet {
    public friendProfile(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizManager qm = (quizManager) request.getServletContext().getAttribute("QUIZ");
        accountManager am = (accountManager) request.getServletContext().getAttribute("MY_DB");

        user friend = (user) request.getAttribute("searchName");
        String name = friend.username;




        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);

    }
}

