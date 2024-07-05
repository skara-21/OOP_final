USE university;
DROP TABLE IF EXISTS user;
CREATE TABLE user(
    userID INT PRIMARY KEY,
    userName CHAR(64) NOT NULL,
    hashedPass CHAR(64) NOT NULL,
    curLevel INT,
    curXp INT
);

DROP TABLE IF EXISTS quiz;
CREATE TABLE quiz(
    quizID INT PRIMARY KEY,
    quizName CHAR(64) NOT NULL,
    creatorID INT,
    creationDate DATE, 
    relativeAddress CHAR(128),
    FOREIGN KEY (creatorID) REFERENCES user(userID)
);

DROP TABLE IF EXISTS quizUser;
CREATE TABLE quizUser(
    userID INT,
    score INT,
    timeUsed FLOAT,
    quizID INT,
    dateTaken DATE,
    FOREIGN KEY (userID) REFERENCES user(userID),
    FOREIGN KEY (quizID) REFERENCES quiz(quizID)
);

DROP TABLE IF EXISTS friends;
CREATE TABLE friends(
    userID INT,
    friendID INT,
    messageSent CHAR(128),
    FOREIGN KEY (userID) REFERENCES user(userID),
    FOREIGN KEY (friendID) REFERENCES user(userID)
);

