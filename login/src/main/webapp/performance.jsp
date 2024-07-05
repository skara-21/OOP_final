<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Performance Page</title>
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
                <label for="searchName" class="search_icon"><i class="fas fa-search"></i></label>
                <input type="text" id="name" name="searchName" required minlength="4" maxlength="64" size="20" />
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
        <section class="home_page ">
            <div class="performance_div1">
                <div class="performance_quiz_name">
                    <h2>Quiz name</h2>
                </div>
                <div class="performance_quiz_text">
                    <h2>Text</h2>
                </div>
            </div>
            <div class="performance_div2">
                <div class="performance_details">
                    <h2>Performance details</h2>
                </div>
                <div class="performance_quiz_answers">
                    <h2>Answers</h2>
                </div>
            </div>
        </section>

    </div>
    <script src="main.js"></script>
</body>

</html>