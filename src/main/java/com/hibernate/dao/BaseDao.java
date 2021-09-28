package com.hibernate.dao;

import java.util.List;

public interface BaseDao<T> {
    void save(T t);
    void update(T t);
    T findById(Object id);
    List<T> findAll();
    void delete(T t);
}
