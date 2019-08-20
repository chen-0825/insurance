package com.java.mapper;
import com.java.pojo.InsuranceUser;
import java.util.List;

public interface InsuranceUserMapper {
    //增
    int add(InsuranceUser insuranceuser);

    //删
    int delete(InsuranceUser insuranceuser);

    //改
    int update(InsuranceUser insuranceuser);

    //查所有
    List<InsuranceUser> findAll();

    //查单条
    InsuranceUser findOne(InsuranceUser insuranceuser);

    //根据条件
    List<InsuranceUser> searchOne(InsuranceUser insuranceuser);

    //批量删
    int batchDelete(String[] iuId);

    //分页
    List<InsuranceUser> findOneSelf(InsuranceUser insuranceuser);
}
