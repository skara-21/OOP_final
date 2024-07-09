<%@ page import="webhelper.quiz" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="shortcut icon" href="images/Bulb.png" type="image/x-icon">
    <script src="https://kit.fontawesome.com/1f82d9d6d9.js" crossorigin="anonymous"></script>
    <style><%@include file="./styles/reset.css"%></style>
    <style><%@include file="./styles/style.css"%></style>

</head>

<body>
<div class="container">

    <!-- HEADER -->
    <header class="header_home">
        <i class="fa-solid fa-bars"></i>
        <i class="fa-solid fa-xmark"></i>


        <a href="HomePage.jsp" class="header_logo_box">
            <img class="header_logo" src="images/RacxaIqneba.png">
        </a>
        <form action="HomePageServlet" method="post">
            <div class="search">
                <input type="text" id="searchName" name="searchName" required minlength="4" maxlength="64" size="20" />
                <button type="submit" class="search_icon"><i class="fas fa-search"></i></button>
            </div>
        </form>

        <div class="friends_section">
            <i class="fas fa-user-friends"></i>
            <i class="fa-solid fa-message"></i>
        </div>
        <div class="profile_sect">
            <h2 class="user_name"><%= request.getAttribute("name")%></h2>
            <form action="profileServlet" method="post">
                <button type="submit" class="user_section">
                    <i class="fa-regular fa-user"></i>
                </button>
            </form>
        </div>



    </header>

    <!-- SECTION 1 -->
    <section class="home_page">
        <div class="quizes">
            <div class="popular_quizes">

                <%
                    ArrayList<quiz> quizzes = (ArrayList<quiz>) request.getAttribute("popularQuizzes");
                    if (quizzes != null && !quizzes.isEmpty()) {
                %>
                <ul>
                    <% for (quiz quiz : quizzes) { %>
                    <li>
                        <form method="post" action="quizPageServlet">
                            <button type="submit"><%= quiz.quizId %>">Quiz Name: <%= quiz.quizName %></button><br>
                            Author: <%= quiz.creator.username %>
                        </form>
                    </li>
                    <% } %>
                </ul>
                <%
                } else {
                %>
                <h2>No popular quizzes</h2>
                <%
                    }
                %>

            </div>
            <div class="recently_created_quizes">
                <div>recently created quizzes</div>
                <%
                    ArrayList<quiz> quizzes1 = (ArrayList<quiz>) request.getAttribute("recentlyCreatedQuizzes");
                    if (quizzes1 != null && !quizzes1.isEmpty()) {
                %>
                <ul>
                    <% for (quiz quiz : quizzes1) { %>
                    <li>
                        <form method="post" action="quizPageServlet">
                            <input type="hidden" name="quizId" value="<%= quiz.quizId %>">
                            <button type="submit"><%= quiz.quizId %>">Quiz Name: <%= quiz.quizName %></button><br>
                            Author: <%= quiz.creator.username %>
                        </form>
                    </li>
                    <% } %>
                </ul>
                <%
                } else {
                %>
                <h2>No recently created quizzes</h2>
                <%
                    }
                %>

            </div>
        </div>
        <div class="news">
            <h2 class="news_feed">News Feed</h2>
        </div>
        <div class="my_quizes">
            <div class="my_written_quizes">

                <%
                    ArrayList<quiz> quizzes2 = (ArrayList<quiz>) request.getAttribute("userCreatedQuizzes");
                    if (quizzes2 != null && !quizzes2.isEmpty()) {
                %>
                <ul>
                    <% for (quiz quiz : quizzes2) { %>
                    <li>
                        <form method="post" action="quizPageServlet">
                            <button type="submit"><%= quiz.quizId %>">Quiz Name: <%= quiz.quizName %></button><br>
                            Author: <%= quiz.creator.username %>
                        </form>
                    </li>
                    <% } %>
                </ul>
                <%
                } else {
                %>
                <h2>No written quizzes to show</h2>
                <%
                    }
                %>

            </div>
            <div class="my_created_quizes">

                <%
                    ArrayList<quiz> quizzes3 = (ArrayList<quiz>) request.getAttribute("userWrittenQuizzes");
                    if (quizzes3 != null && !quizzes3.isEmpty()) {
                %>
                <ul>
                    <% for (quiz quiz : quizzes3) { %>
                    <li>
                        <form method="post" action="quizPageServlet">
                            <button type="submit"><%= quiz.quizId %>">Quiz Name: <%= quiz.quizName %></button><br>
                            Author: <%= quiz.creator.username %>
                        </form>
                    </li>
                    <% } %>
                </ul>
                <%
                } else {
                %>
                <h2>No quizzes to show</h2>
                <%
                    }
                %>

            </div>
        </div>
    </section>

</div>
</body>

</html>