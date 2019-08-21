package com.java.mapper;

import com.java.pojo.Lp;

import java.util.List;

public interface LpMapper {
    //增加
    int insertLp(Lp lp);

    //修改
    int updateLp(Lp lp);

    //模糊查询
    List<Lp> findLp(Lp lp);
}
