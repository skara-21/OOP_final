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
                question.addAnswer(answer);
                break;
            case "2":
                String answer1 = request.getParameter("question_answer");
                question = new Question(questionName, 2);
                question.addAnswer(answer1);
                break;
            case "3":
                ArrayList<String> answersArray= new ArrayList<>(); {
                String option1 = request.getParameter("question_answer1");
                String option2 = request.getParameter("question_answer2");
                String option3 = request.getParameter("question_answer3");
                String option4 = request.getParameter("question_answer4");
                }
                question = new Question(questionName, 3);
                question.answers = answersArray;
                question.addCorrectAnswer(request.getParameter("answers"));
                break;
            case "4":
                String answer4 = request.getParameter("question_answer");
                question = new Question(questionName, 4);
                question.addAnswer(answer4);
                break;
            default:
                break;
        }



    }
}
