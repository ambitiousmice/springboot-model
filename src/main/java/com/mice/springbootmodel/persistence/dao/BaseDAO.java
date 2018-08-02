package com.mice.springbootmodel.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: ChenHao
 * @Date: 2018/5/11 11:38
 */
public interface BaseDAO<T,J> {
    Integer insert(T var1);

    Integer update(T var1);

    Integer dynamicUpdate(T var1);

    T selectById(Serializable var1);

    Integer delById(Serializable var1);

    List<T> dynamicSelect(T var1);

    List<T> selectList(T var1);

    List<T> dynamicSelectPage(J var1);

    List<T> dynamicCount(J var1);


}
