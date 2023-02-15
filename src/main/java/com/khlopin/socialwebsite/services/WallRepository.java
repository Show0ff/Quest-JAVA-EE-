package com.khlopin.socialwebsite.services;


import com.khlopin.socialwebsite.entity.user.Post;
import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.entity.user.Wall;
import com.khlopin.socialwebsite.services.questServices.Repository;
import com.khlopin.socialwebsite.utills.DB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class WallRepository implements Repository<Wall> {

    private final HashMap<Long, Wall> wallMap = new HashMap<>();
    private static final AtomicLong wallId = new AtomicLong(0);
    private static final Logger log = LogManager.getLogger(WallRepository.class);

    //TODO доделать имплантированные методы

    public Long create(User ownerUser, List<Post> postList) {
        wallMap.put(wallId.incrementAndGet(), new Wall(wallId.get(), ownerUser, postList));
        return wallId.get();
    }

    public void createWallWithPostListForUser(User user) {
        Long idListOfPostsForCurrentUser = DB.postDataBase.createListOfPosts();
        Long idOfWallForCurrentUser = DB.wallDataBase.create(user, DB.postDataBase.get(idListOfPostsForCurrentUser));
        user.setWall(DB.wallDataBase.get(idOfWallForCurrentUser));
    }

    @Override
    public Wall get(long id) {
        return wallMap.get(id);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(long idOfOlderEntity, Wall entity) {

    }

    @Override
    public Collection<Wall> getAll() {
        return null;
    }
}
