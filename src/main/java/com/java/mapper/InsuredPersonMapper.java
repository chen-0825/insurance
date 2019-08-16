package com.java.mapper;
import com.java.pojo.InsuredPerson;
import java.util.List;

public interface InsuredPersonMapper {
    //增
    int add(InsuredPerson insuredperson);

    //删
    int delete(InsuredPerson insuredperson);

    //改
    int update(InsuredPerson insuredperson);

    //查所有
    List<InsuredPerson> findAll();

    //查单条
    InsuredPerson findOne(InsuredPerson insuredperson);

    //根据条件
    List<InsuredPerson> searchOne(InsuredPerson insuredperson);

    //批量删
    int batchDelete(String[] ipId);

    //分页
    List<InsuredPerson> findOneSelf(InsuredPerson insuredperson);
}
