package webhelper;

import java.util.ArrayList;

public class quizManager {

    private ArrayList<quiz> popularQuizzes;
    private ArrayList<quiz> recentlyCreatedQuizzes;
    private ArrayList<quiz> userCreatedQuizzes;
    private ArrayList<quiz> userWrittenQuizzes;
    private user currentUser;

    public quizManager(String username, int id){
        currentUser = new user(username, id);
        popularQuizzes = new ArrayList<>();
        recentlyCreatedQuizzes = new ArrayList<>();
        userCreatedQuizzes = new ArrayList<>();
        userWrittenQuizzes = new ArrayList<>();

        userCreatedQuizzes.addAll(currentUser.getCreatedQuizzes());
        userWrittenQuizzes.addAll(currentUser.getWrittenQuizzes());


    }

    public ArrayList<quiz> getPopularQuizzes() {
        popularQuizzes = dbquiz.getPopularQuizzesdb();
        return popularQuizzes;
    }

    public ArrayList<quiz> getRecentlyCreatedQuizzes() {
        recentlyCreatedQuizzes = dbquiz.getRecentQuizzesdb();
        return recentlyCreatedQuizzes;
    }

    public ArrayList<quiz> getUserCreatedQuizzes() {
        return userCreatedQuizzes;
    }

    public ArrayList<quiz> getUserWrittenQuizzes() {
        return userWrittenQuizzes;
    }



}
