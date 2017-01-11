package com.wzguo.mongo.dao;

import java.util.List;

/**
 * Created by admin on 2017/1/11.
 */
public interface Dao {

    public void save(Object obj);


    public void delete(Object obj);


    public void update(Object obj);


    public Object find(Object obj);


    public List<Object> finds();

    public long total();

    public List<Object> finds(int index, int offset);
}
