package com.java.mapper;

import com.java.pojo.Policys;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    //单条删除
    int guaranteedelete(String policyId);

    //条件查询
    List<Policys> tiaojianfind(Policys po);

    //修改保单状态
    int update(String policyId,String policyState);

    //根据日期修改保单为退保
    int updatepolicyState(String end);
}
