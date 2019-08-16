package com.java.service;

import com.java.pojo.Lpgl;

import java.util.List;

public interface LpglService {
    //增加
    int insertLpgl(Lpgl lpgl);
    //删除
    int deleteLpgl(Integer id);
    //批量删除
    int deleteLpgls(List<Integer> list);

    //修改
    int updateLpgl(Lpgl lpgl);

    //查询所有
    List<Lpgl> findAll();
    //条件查询
    List<Lpgl> findBy(Lpgl lpgl);
}
