package com.khlopin.socialwebsite.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private Long id;
    private User user;
    private String text;

    @Override
    public String toString() {
        return "Post " +
                "id of post = " + id +
                ", user = " + user +
                ", text = '" + text;
    }
}
