package webhelper;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
    public HomePageServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizManager qm=(quizManager) request.getServletContext().getAttribute("QUIZ");
        System.out.println("hello");
        ArrayList<quiz> popularQuizzes = qm.getPopularQuizzes();
        ArrayList<quiz> recentlyCreatedQuizzes = qm.getRecentlyCreatedQuizzes();
        ArrayList<quiz> userCreatedQuizzes = qm.getUserCreatedQuizzes();
        ArrayList<quiz> userWrittenQuizzes = qm.getUserWrittenQuizzes();

        request.setAttribute("popularQuizzes", popularQuizzes);
        request.setAttribute("recentlyCreatedQuizzes", recentlyCreatedQuizzes);
        request.setAttribute("userCreatedQuizzes", userCreatedQuizzes);
        request.setAttribute("userWrittenQuizzes", userWrittenQuizzes);

        accountManager am = (accountManager) request.getServletContext().getAttribute("AM");


        request.setAttribute("getFeedInfoCreated", qm.createdFeed());
        request.setAttribute("getFeedInfoTaken", qm.takenFeed());
        request.setAttribute("username", am.getCurrUser().username);

        String searchName = request.getParameter("searchName");
        user searchResults = am.searchAccountByName(searchName);

        if (searchResults != null) {
            request.setAttribute("searchResults", searchResults);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
           //if search is null
        }

        request.getRequestDispatcher("profile.jsp").forward(request, response);

        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

    }
}

