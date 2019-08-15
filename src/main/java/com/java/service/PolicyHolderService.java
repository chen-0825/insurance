package com.java.service;
import com.java.pojo.PolicyHolder;
import java.util.List;

public interface PolicyHolderService {
    //增
    int add(PolicyHolder policyholder);

    //删
    int delete(PolicyHolder policyholder);

    //改
    int update(PolicyHolder policyholder);

    //查所有
    List<PolicyHolder> findAll();

    //查单条
    PolicyHolder findOne(PolicyHolder policyholder);

    //根据条件
    List<PolicyHolder> searchOne(PolicyHolder policyholder);

    //批量删
    int batchDelete(String[] phid);

    //分页
    List<PolicyHolder> findOneSelf(PolicyHolder policyholder);
}