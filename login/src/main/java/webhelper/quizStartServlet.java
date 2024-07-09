package webhelper;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/quizStartServlet")
public class quizStartServlet extends HttpServlet {
    public quizStartServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountManager am = (accountManager) request.getServletContext().getAttribute("MY_DB");
        quiz currQuiz = am.getCurrQuiz();
        String title = currQuiz.quizName;
        int index = am.curQuestionIndex;
        ArrayList<Question> questions = currQuiz.questions;

        request.setAttribute("quiz_title", title);
        if(index == 0){
           am.curQuestionIndex++;
           request.getRequestDispatcher("quizStart.jsp").forward(request, response);
           System.out.println(am.curQuestionIndex + "Quiz started");
        }
        else if(index <= questions.size()){
            Question question = questions.get(index - 1);
            request.setAttribute("question", question.getQuestion());
            if(question.getType() == 1){
                request.getRequestDispatcher("quizQuestion1.jsp").forward(request, response);
            }
            else if(question.getType() == 2){
                request.getRequestDispatcher("quizQuestion2.jsp").forward(request, response);
            }
            else if(question.getType() == 3){
                String answer1 = question.answers.get(0);
                String answer2 = question.answers.get(1);
                String answer3 = question.answers.get(2);
                String answer4 = question.answers.get(3);
                request.setAttribute("answer1", answer1);
                request.setAttribute("answer2", answer2);
                request.setAttribute("answer3", answer3);
                request.setAttribute("answer4", answer4);
                request.getRequestDispatcher("quizQuestion3.jsp").forward(request, response);
            }
            else if(question.getType() == 4){
                request.getRequestDispatcher("quizQuestion4.jsp").forward(request, response);
            }
            am.curQuestionIndex++;
            System.out.println(am.curQuestionIndex - 1 + "Quiz started");
        }
        else {
            am.curQuestionIndex = 0;
            request.getRequestDispatcher("HomePageServlet").forward(request, response);
        }

    }
}

