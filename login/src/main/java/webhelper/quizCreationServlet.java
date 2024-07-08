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
        String quizDescription = request.getParameter("quizDescription");
        Boolean isOrdered = request.getParameter("isOrdered") != null;
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);


        quiz currentQuiz = (quiz) request.getSession().getAttribute("currentQuiz");
        if (currentQuiz == null) {
            currentQuiz = new quiz(quizName, curUser, 0, sqlDate, isOrdered);
            currentQuiz.setDescription(quizDescription);
            request.getSession().setAttribute("currentQuiz", currentQuiz);
        }else{
            currentQuiz = (quiz) request.getSession().getAttribute("currentQuiz");
        }


        String action = request.getParameter("action");
        String questionTypeStr = request.getParameter("questionType");
        String questionType = String.valueOf(questionTypeStr != null ? Integer.parseInt(questionTypeStr) : -1);



        if ("next".equals(action) || "finish".equals(action)) {
            String questionText = request.getParameter("questionText");
            String correctAnswer = request.getParameter("correctAnswer");
            String[] answers = request.getParameterValues("answers");

            Question question = new Question(questionText, Integer.parseInt(questionTypeStr) );
            question.addCorrectAnswer(correctAnswer);
            if (answers != null) {
                for (String answer : answers) {
                    question.addAnswer(answer);
                }
            }

            currentQuiz.questions.add(question);

            if ("finish".equals(action)) {
                currentQuiz.createFile();
                qd.add(currentQuiz);
                request.getSession().removeAttribute("currentQuiz");

                request.setAttribute("message", "Quiz created successfully!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/quizCreationSuccess.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        request.setAttribute("quizName", quizName);
        request.setAttribute("quizDescription", quizDescription);
        request.setAttribute("isOrdered", isOrdered);
        request.setAttribute("questions", currentQuiz.questions);

        switch (questionType) {
            case "1":
                request.getRequestDispatcher("Question1.jsp").forward(request, response);
                break;
            case "2":
                request.getRequestDispatcher("Question2.jsp").forward(request, response);
                break;
            case "3":
                request.getRequestDispatcher("Question3.jsp").forward(request, response);
                break;
            case "4":
                request.getRequestDispatcher("Question4.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("Questions.jsp").forward(request, response);
                break;
        }




    }
}
