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

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizDatabase qm = (quizDatabase) request.getServletContext().getAttribute("QUIZ");
        accountManager am = (accountManager) request.getServletContext().getAttribute("MY_DB");

        user currUser = am.getCurrUser();
        String name = currUser.username;

        ArrayList<quiz> writtenQuizzes = currUser.getWrittenQuizzes();
        ArrayList<quiz> createdQuizzes = currUser.getCreatedQuizzes();
        ArrayList<user> friendList = currUser.getFriendList();

        request.setAttribute("writtenQuizzes", writtenQuizzes);
        request.setAttribute("createdQuizzes", createdQuizzes);
        request.setAttribute("friendList", friendList);


        request.setAttribute("username1",name);

        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);

    }
}

