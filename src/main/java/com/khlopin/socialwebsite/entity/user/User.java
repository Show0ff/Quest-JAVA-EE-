package com.khlopin.socialwebsite.entity.user;


import com.khlopin.socialwebsite.entity.game.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String password;
    private Role role;
    private Wall wall;
    private List<Game> gameList;

    public String toString() {
        return "User id=" + this.getId() + ", userName=" + this.getUserName() + ", role=" + this.getRole();
    }

    public User(Long id, String userName, String password, Role role, List<Game> gameList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.gameList = gameList;
    }
}
