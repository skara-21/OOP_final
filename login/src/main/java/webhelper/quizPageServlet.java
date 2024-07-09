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
        //quizManager qm =(quizManager) request.getServletContext().getAttribute("QUIZ");
        quizDatabase quizDatabase = (quizDatabase) getServletContext().getAttribute("QUIZ");
        accountManager am = (accountManager) getServletContext().getAttribute("MY_DB");

        int quizId = Integer.parseInt(request.getParameter("quizId"));
        request.setAttribute("quiz_name", quizDatabase.getQuizById(quizId).quizName);
        request.setAttribute("description", quizDatabase.getQuizById(quizId).description);

        request.setAttribute("creator", quizDatabase.getQuizById(quizId).creator.username);

        am.setCurrQuiz(quizDatabase.getQuizById(quizId));
        request.getRequestDispatcher("quiz.jsp").forward(request, response);

    }
}

