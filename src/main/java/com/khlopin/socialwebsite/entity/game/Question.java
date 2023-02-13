package com.khlopin.socialwebsite.entity.game;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question extends GameEntity {

    private Long id;

    private Long questId;
    private Long nextQuestionId;

    private String text;
    private List<Answer> answerList;

}
