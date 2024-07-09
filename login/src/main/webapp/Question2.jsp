<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question</title>
    <link rel="shortcut icon" href="images/RacxaIqneba.png" type="image/x-icon">
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
        <div class="search">
            <label for="name" class="search_icon"><i class="fas fa-search"></i></label>
            <input type="text" id="name" name="name" required minlength="4" maxlength="64" size="20" />

        </div>
        <div class="friends_section">
            <i class="fas fa-user-friends"></i>
            <i class="fa-solid fa-message"></i>
        </div>
        <a href="profile.jsp" class="user_section">
            <i class="fa-regular fa-user"></i>
        </a>
    </header>

    <!-- SECTION 1 -->
    <section class="home_page">
        <div class="create_quiz create_question">
            <form action="questionServlet" method="post">
                <div class="question_info">
                    <input type="text" id="quiz_name" name="question_name" placeholder="Enter Question" required minlength="10" maxlength="64" size="20" />
                    <input type="text" class="question_answer quest2_answer" name="question_answer" placeholder="Enter Answer" required minlength="0" maxlength="64" size="20" />
                </div>
                <button type="submit" name="act" class="next_but">Next</button>

                <div class="quest_buts">
                    <button type="submit" name="act" class="finish_but"><a href="HomePage.jsp" class="finish">Finish</a></button>
                </div>
            </form>
        </div>
    </section>

</div>
</body>

</html>