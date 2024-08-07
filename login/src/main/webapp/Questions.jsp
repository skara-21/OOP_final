<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question Type</title>
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
        <form action="chooseTypeServlet" method="post">
            <div class="create_quiz create_question">
                <form action="SubmitQuizServlet" method="post">
                <div class="quiz_info ">
                    <label class="type_label" for="types">Choose question type:</label>
                    <select name="types" id="types" required>
                        <option value="none" class="types" selected disabled hidden>Select an Option</option>
                        <option value="1" class="types">Question-response</option>
                        <option value="2" class="types">Fill in</option>
                        <option value="3" class="types">Multiple choice</option>
                        <option value="4" class="types">Picture-response</option>
                    </select>
                </div>
                <button type="submit" class="next_but">Next</button>
                </form>

                    <form action="SubmitQuizServlet" method="post">
                        <button type="submit" class="finish_but">Finish</button>
                    </form>
            </div>
        </form>
    </section>

</div>
</body>

</html>