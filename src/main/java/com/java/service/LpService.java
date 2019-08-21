package com.java.service;

import com.java.pojo.Lp;

import java.util.List;

public interface LpService {
    //增加
    int insertLp(Lp lp);

    //修改
    int updateLp(Lp lp);

    //模糊查询
    List<Lp> findLp(Lp lp);
}
