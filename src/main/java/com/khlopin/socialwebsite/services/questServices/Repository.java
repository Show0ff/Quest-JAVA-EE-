package com.khlopin.socialwebsite.services.questServices;



import java.util.Collection;


public interface Repository<T> {


    T get(long id);
    void delete(long id);
    void update(long idOfOlderEntity, T entity);
    Collection<T> getAll();

}
