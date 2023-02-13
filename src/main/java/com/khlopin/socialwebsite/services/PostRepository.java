package com.khlopin.socialwebsite.services;


import com.khlopin.socialwebsite.entity.user.Post;
import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.services.questServices.Repository;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepository implements Repository<ArrayList<Post>> {

    private final HashMap<Long, ArrayList<Post>> postsMap = new HashMap<>();
    private static final AtomicLong postId = new AtomicLong(0);
    private static final AtomicLong postListId = new AtomicLong(0);

    public void addPostInListOfPostsInWall(Long idOfWall, User user, String text) {
        postsMap.get(idOfWall).add(new Post(postId.incrementAndGet(),user, text));
    }

    //TODO доделать имплантированные методы
    public Long createListOfPosts() {
        ArrayList<Post> postList = new ArrayList<>();
        postsMap.put(postListId.incrementAndGet(),postList);
        return postListId.get();
    }

    @Override
    public ArrayList<Post> get(long id) {
        return postsMap.get(id);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(long idOfOlderEntity, ArrayList<Post> entity) {

    }

    @Override
    public Collection<ArrayList<Post>> getAll() {
        return null;
    }



}
