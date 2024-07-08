package webhelper;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/quizCreationServlet")
public class quizCreationServlet extends HttpServlet {

    public quizCreationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if necessary
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizDatabase qd = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");
        accountManager db=(accountManager) getServletContext().getAttribute("MY_DB");
        user curUser = db.getCurrUser();


        String quizName = request.getParameter("quizName");
        System.out.println(quizName);
        String quizDescription = request.getParameter("quizDescription");
        Boolean isOrdered = request.getParameter("isOrdered") != null;
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

        quiz newQuiz = new quiz(quizName, curUser, 0, sqlDate, isOrdered);
        newQuiz.setDescription(quizDescription);



        request.setAttribute("message", "Quiz created successfully!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/quizCreationSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
