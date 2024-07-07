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
    <script>
        // JavaScript function to handle click event on user_section
        function goToProfile() {
            // Redirect to HomePageServlet with action=profile
            window.location.href = "HomePageServlet?action=profile";
        }
    </script>
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
                <input type="text" id="searchName" name="searchName" required minlength="4" maxlength="64" size="20" />

            </div>
            <div class="friends_section">
                <i class="fas fa-user-friends"></i>
                <i class="fa-solid fa-message"></i>
            </div>
            <!-- Calling goToProfile function on click -->
            <a href="#" class="user_section" onclick="goToProfile()">
                <i class="fa-regular fa-user"></i>
            </a>

        </header>

        <!-- SECTION 1 -->
        <section class="home_page">
            <div class="quizes">
                <div class="popular_quizes">
                    <h2>popular quizes</h2>
                </div>
                <div class="recently_created_quizes">
                    <h2>recently created quizes</h2>
                </div>
            </div>
            <div class="news">
                <h2 class="news_feed">News Feed</h2>
            </div>
            <div class="my_quizes">
                <div class="my_written_quizes">
                    <h2>recently created quizes</h2>
                </div>
                <div class="my_created_quizes">
                    <h2>recently created quizes</h2>
                </div>
            </div>
        </section>

    </div>
    <script src="main.js"></script>
</body>

</html>