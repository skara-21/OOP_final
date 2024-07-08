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


        <a href="index.html" class="header_logo_box">
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
        <a href="contact.html" class="user_section">
            <i class="fa-regular fa-user"></i>
        </a>
    </header>

    <!-- SECTION 1 -->
    <section class="home_page">
        <div class="create_quiz">
            <div class="question_info">
                <input type="text" id="quiz_name" name="question_name" placeholder="Enter Question" required minlength="10" maxlength="64" size="20" />
                <input type="text" class="question_answer" name="question_answer" placeholder="Enter Answer1" required minlength="0" maxlength="64" size="20" />
                <input type="text" class="question_answer" name="question_answer" placeholder="Enter Answer2" required minlength="0" maxlength="64" size="20" />
                <input type="text" class="question_answer" name="question_answer" placeholder="Enter Answer3" required minlength="0" maxlength="64" size="20" />
                <input type="text" class="question_answer" name="question_answer" placeholder="Enter Answer4" required minlength="0" maxlength="64" size="20" />
            </div>
            <label class="answers_label" for="answers">Choose Correct answer</label>
            <select name="answers" id="answers" value="Choose Answer" required>
                <option value="none" class="types" selected disabled hidden>Select an Answer</option>
                <option value="1" class="types">1</option>
                <option value="2" class="types">2</option>
                <option value="3" class="types">3</option>
                <option value="4" class="types">4</option>
            </select>
            <div class="quest_buts">
                <button class="next_but"><a href="Questions.html" class="quest_link">Next</a></button>
                <button class="finish_but"><a href="index.html" class="finish">Finish</a></button>
            </div>

        </div>
    </section>

</div>
</body>

</html>