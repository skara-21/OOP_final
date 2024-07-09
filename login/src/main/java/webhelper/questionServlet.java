package webhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/questionServlet")
public class questionServlet extends HttpServlet {

    public questionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizDatabase qd = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");
        accountManager db=(accountManager) getServletContext().getAttribute("MY_DB");
        user curUser = db.getCurrUser();

        String questionType = request.getAttribute("questionType").toString();


        String questionName = request.getParameter("questionName");
        Question question;
        switch (questionType) {

            case "1":
                String answer = request.getParameter("question_answer");
                 question = new Question(questionName, 1);

                break;
            case "2":
                String answer1 = request.getParameter("question_answer");
                question = new Question(questionName, 2);

                break;
            case "3":

                break;
            case "4":

                break;
            default:
                break;
        }





    }
}
