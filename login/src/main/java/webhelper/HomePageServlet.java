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
        quizDatabase qm=(quizDatabase) request.getServletContext().getAttribute("QUIZ");
        accountManager am=(accountManager) request.getServletContext().getAttribute("MY_DB");

        ArrayList<quiz> popularQuizzes = qm.getPopularQuizzesdb();
        ArrayList<quiz> recentlyCreatedQuizzes = qm.getRecentQuizzesdb();
        ArrayList<quiz> userCreatedQuizzes = qm.getCreatedQuizesById(am.getCurrUser().userId);
        ArrayList<quiz> userWrittenQuizzes = qm.getWrittenQuizzesById(am.getCurrUser().userId);
        request.setAttribute("popularQuizzes", popularQuizzes);
        request.setAttribute("recentlyCreatedQuizzes", recentlyCreatedQuizzes);
        request.setAttribute("userCreatedQuizzes", userCreatedQuizzes);
        request.setAttribute("userWrittenQuizzes", userWrittenQuizzes);

        //accountManager am = (accountManager) request.getServletContext().getAttribute("AM");


        request.setAttribute("getFeedInfoCreated", am.getCurrUser().getFeedInfoCreated());
        request.setAttribute("getFeedInfoTaken", am.getCurrUser().getFeedInfoTaken());
        request.setAttribute("username", am.getCurrUser().username);

        String searchName = request.getParameter("searchName");
        user searchResults = am.searchAccountByName(searchName);

        if (searchResults != null) {
            request.setAttribute("searchResults", searchResults);
            request.getRequestDispatcher("friendProfile.jsp").forward(request, response);
        } else {

        }


        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

    }
}

