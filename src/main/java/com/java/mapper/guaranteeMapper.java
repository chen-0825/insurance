package com.java.mapper;

import com.java.pojo.Policys;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zl
 * @create 2019-08-14 18:53
 */
public interface guaranteeMapper {

    //增
    int guaranteeinsert(Policys po);

    //查所有
    List<Policys> guaranteesfindAll();
}