package webhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/quizCreationServlet")
public class quizCreationServlet extends HttpServlet {

    public quizCreationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizDatabase qd = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");
        accountManager db=(accountManager) getServletContext().getAttribute("MY_DB");
        user curUser = db.getCurrUser();


        String quizName = request.getParameter("quizName");
        String desc = request.getParameter("quizDescription" );
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

        quiz newQuiz = new quiz(quizName, curUser, 0, sqlDate,true);
        qd.add(newQuiz);
        db.setQuiz(newQuiz);


        request.getRequestDispatcher("Questions.jsp").forward(request, response);

    }
}
