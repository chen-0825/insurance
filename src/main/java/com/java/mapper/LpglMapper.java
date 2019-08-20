package com.java.mapper;

import com.java.pojo.Lpgl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LpglMapper {
    //增加
    int insertLpgl(Lpgl lpgl);
    //删除
    int deleteLpgl(Integer id);
    //批量删除
    int deleteLpgls(List<Integer> list);

    //修改
    int updateLpgl(Lpgl lpgl);

    //条件查询
    List<Lpgl> findBy(@Param("id") Integer id, @Param("ss")String ss, @Param("desc")String desc, @Param("ord")String ord);
}
