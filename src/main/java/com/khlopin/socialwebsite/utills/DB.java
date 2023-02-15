package com.khlopin.socialwebsite.utills;


import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.services.PostRepository;
import com.khlopin.socialwebsite.services.UserRepository;
import com.khlopin.socialwebsite.services.WallRepository;
import com.khlopin.socialwebsite.services.questServices.AnswerRepository;
import com.khlopin.socialwebsite.services.questServices.QuestRepository;
import com.khlopin.socialwebsite.services.questServices.QuestionRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DB {
    public static AnswerRepository answerDataBase = new AnswerRepository();
    public static QuestionRepository questionDataBase = new QuestionRepository();
    public static UserRepository userDataBase = new UserRepository();
    public static PostRepository postDataBase = new PostRepository();
    public static WallRepository wallDataBase = new WallRepository();
    public static QuestRepository questDataBase = new QuestRepository();


    public static void initWallsForMap() {
        for (User user : DB.userDataBase.getAll()) {
            Long idListOfPostsForCurrentUser = DB.postDataBase.createListOfPosts();
            Long idOfWallForCurrentUser = DB.wallDataBase.create(user, DB.postDataBase.get(idListOfPostsForCurrentUser));
            user.setWall(DB.wallDataBase.get(idOfWallForCurrentUser));
        }
    }

}
