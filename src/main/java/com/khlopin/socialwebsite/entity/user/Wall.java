package com.khlopin.socialwebsite.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Wall {
    private Long id;
    private User ownerUser;
    private List<Post> postList;


    @Override
    public String toString() {
        return "id of Wall = " + id +
                ", owner of Wall = " + ownerUser +
                ", posts = " + postList
                ;
    }
}
