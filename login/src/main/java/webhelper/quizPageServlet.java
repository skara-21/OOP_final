package webhelper;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/quizPageServlet")
public class quizPageServlet extends HttpServlet {
    public quizPageServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizManager qm =(quizManager) request.getServletContext().getAttribute("QUIZ");
        quizDatabase quizDatabase = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");

        int quizId = Integer.parseInt(request.getParameter("quizId"));
        quiz quiz = quizDatabase.getQuizById(quizId);

        request.setAttribute("quiz_name", quiz.quizName);
        request.setAttribute("quiz_id", quizId);
        request.setAttribute("quiz_text", quiz.description);
        request.setAttribute("quiz_last", quizDatabase.getLastPerformances(quizId, user));
        request.setAttribute("quiz_highest", quizDatabase.getHighestPerformers(quizId, true));
        request.setAttribute("quiz_recent", quizDatabase.getRecentTestTakers(quizId));
        request.setAttribute("quiz_stats", quizDatabase.getStatisticsdb(userId, true));

        String action = request.getParameter("action");
        switch (action) {
            case "practice":
                request.getRequestDispatcher("practice.jsp").forward(request, response);
                break;
            case "start":
                request.getRequestDispatcher("start.jsp").forward(request, response);
                break;
            default:
                break;
        }

        request.getRequestDispatcher("quizPage.jsp").forward(request, response);

    }
}
