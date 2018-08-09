package com.service;

import com.comment.bean.SearchObject;

import java.util.List;

/**
 * Created by daixuan on 2018/7/11 9:48
 */
public interface commentInterface<T> {

    public void add(T bean);

    public void update(T bean);

    public void delete(List<Integer> id);

    public <T> T query(SearchObject<T> searchObject);
}

