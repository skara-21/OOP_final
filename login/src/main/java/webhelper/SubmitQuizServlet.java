package webhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SubmitQuizServlet")
public class SubmitQuizServlet extends HttpServlet {

    public SubmitQuizServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizDatabase qd = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");
        accountManager db=(accountManager) getServletContext().getAttribute("MY_DB");
        user curUser = db.getCurrUser();

        quiz Quiz = db.getCurrQuiz();
        curUser.createQuiz(Quiz);
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);


    }
}
