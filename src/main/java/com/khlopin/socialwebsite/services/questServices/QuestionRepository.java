package com.khlopin.socialwebsite.services.questServices;



import com.khlopin.socialwebsite.entity.game.Answer;
import com.khlopin.socialwebsite.entity.game.Question;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class QuestionRepository implements Repository<Question> {

    private final HashMap<Long, Question> questionsMap = new HashMap<>();
    private static final AtomicLong questionId = new AtomicLong(0);



    public Question create(Long nextQuestionId, long questId, String value, List<Answer> answerList) {
        long idForQuest = questionId.incrementAndGet();
        return new Question(idForQuest, questId, nextQuestionId, value, answerList);
    }




    @Override
    public Question get(long id) {
        return questionsMap.get(id);
    }

    @Override
    public void delete(long id) {
        questionsMap.remove(id);
    }

    @Override
    public void update(long idOfOlderEntity, Question question) {
        delete(idOfOlderEntity);
        questionsMap.put(idOfOlderEntity,question);
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questionsMap.values());
    }


}
