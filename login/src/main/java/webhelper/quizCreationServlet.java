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
        quizManager qm = (quizManager) request.getServletContext().getAttribute("QUIZ");
        quizDatabase quizDatabase = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");
        ServletContext context = request.getServletContext();

        String quizName = request.getParameter("quizName");
        String quizDescription = request.getParameter("quizDescription");
        Boolean isOrdered = request.getParameter("isOrdered") != null;
        user curUser = (user) context.getAttribute("curUser");
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

        quiz newQuiz = new quiz(quizName, curUser, 0, sqlDate, isOrdered);
        newQuiz.setDescription(quizDescription);

        String[] questionTypes = request.getParameterValues("questionType");
        String[] questions = request.getParameterValues("question");
        String[] correctAnswers = request.getParameterValues("correctAnswer");

        if (questionTypes != null && questions != null) {
            for (int i = 0; i < questionTypes.length; i++) {
                int questionType = Integer.parseInt(questionTypes[i]);
                String questionText = questions[i];
                Question question = new Question(questionText, questionType);

                switch (questionType) {
                    case 1:

                        question.addCorrectAnswer(correctAnswers[i]);
                        break;
                    case 2:

                        question.addCorrectAnswer(correctAnswers[i]);
                        break;
                    case 3:

                        String[] options = request.getParameterValues("options" + (i + 1));
                        if (options != null) {
                            for (String option : options) {
                                question.addAnswer(option);
                            }
                        }
                        question.addCorrectAnswer(correctAnswers[i]);
                        break;
                    case 4:
                        // Picture-Response
                        question.addCorrectAnswer(correctAnswers[i]);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid question type: " + questionType);
                }
                newQuiz.addQuestion(question);
            }
        }

        quizDatabase.add(newQuiz);


        request.setAttribute("message", "Quiz created successfully!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/quizCreationSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
