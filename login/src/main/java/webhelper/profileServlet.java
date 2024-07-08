package webhelper;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {
    public profileServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String test = "test";

            request.setAttribute("test", test);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizManager qm = (quizManager) request.getServletContext().getAttribute("QUIZ");
        accountManager am = (accountManager) request.getServletContext().getAttribute("MY_DB");

        user currUser = am.getCurrUser();
        String name = currUser.username;


        request.setAttribute("username1",name);

        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);

        doGet(request, response);

    }
}

