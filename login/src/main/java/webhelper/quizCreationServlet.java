package webhelper;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@WebServlet("/quizCreationServlet")
public class quizCreationServlet extends HttpServlet {

    public quizCreationServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizManager qm =(quizManager) request.getServletContext().getAttribute("QUIZ");
        quizDatabase quizDatabase = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");
        ServletContext context = request.getServletContext();

        String quizName = request.getParameter("quizName");
        String quizDescription = request.getParameter("quizDescription");
        Boolean isOrdered = request.getParameter("isOrdered") != null;
        user curUser = (user) context.getAttribute("curUser");
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

        quiz newQuiz = new quiz(quizName, curUser, 0, sqlDate, isOrdered); // quizId will be set by the database
        newQuiz.setDescription(quizDescription);

        quizDatabase.add(newQuiz);




    }
}

