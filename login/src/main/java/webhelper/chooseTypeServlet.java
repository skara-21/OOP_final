package webhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/chooseTypeServlet")
public class chooseTypeServlet extends HttpServlet {

    public chooseTypeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizDatabase qd = (quizDatabase) getServletContext().getAttribute("QUIZ_DATABASE");
        accountManager db=(accountManager) getServletContext().getAttribute("MY_DB");
        user curUser = db.getCurrUser();

        String questionType = request.getParameter("questionType");

        request.setAttribute("questionType", questionType);
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
                    break;
            }





    }
}
