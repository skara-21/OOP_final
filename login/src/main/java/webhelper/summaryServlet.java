package webhelper;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/summaryServlet")
public class summaryServlet extends HttpServlet {
    public summaryServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountManager am = (accountManager) request.getServletContext().getAttribute("MY_DB");
        ArrayList<String> submitted = am.submitted;
        ArrayList<Question> correct = am.getCurrQuiz().questions;
        int score = 0;
        for(int i = 0; i < correct.size(); i++){
            System.out.println(correct.get(i).getCorrectAnswer());
            System.out.println(submitted.get(i + 1));
            if(correct.get(i).getCorrectAnswer().equals(submitted.get(i + 1))){
                score++;
            }
        }
        request.setAttribute("quizName", am.getCurrQuiz().quizName);
request.setAttribute("score", score);
        am.getCurrUser().addWrittenQuiz(am.getCurrQuiz(),score);
        request.getRequestDispatcher("performance.jsp").forward(request, response);

        }

    }


