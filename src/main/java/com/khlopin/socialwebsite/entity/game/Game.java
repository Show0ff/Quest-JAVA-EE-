package com.khlopin.socialwebsite.entity.game;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game extends GameEntity {

    private Quest quest;
    private GameState gameState;


}
