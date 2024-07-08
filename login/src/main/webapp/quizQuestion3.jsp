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
                <h2 class="quiz_title question1">Libero, voluptate nesciunt quisquam animi omnis eum dicta veniam fugit minima eveniet tenetur explicabo minus, quos obcaecati dolorem nam nulla qui incidunt?</h2>
                <ul class="choices">
                    <li>
                        <div class="answer">
                            <input type="radio" class="choose" name="question0" value="A"/>
                            <span>lorem</span>
                        </div>
                    </li>
                    <li>
                        <div class="answer">
                            <input type="radio" class="choose" name="question0" value="B"/>
                            <span>lorem</span>
                        </div>
                    </li>
                    <li>
                        <div class="answer">
                            <input type="radio" class="choose" name="question0" value="C"/>
                            <span>lorem</span>
                        </div>
                    </li>
                    <li>
                        <div class="answer">
                            <input type="radio" class="choose" name="question0" value="D"/>
                            <span>lorem</span>
                        </div>
                    </li>
                </ul>
            </div>
            <button class="next_but"><a href="Questions.html" class="quest_link">Next</a></button>
        </div>
    </section>

</div>
</body>

</html>