package com.java.service.impl;
import com.java.mapper.PolicyHolderMapper;
import com.java.pojo.PolicyHolder;
import com.java.service.PolicyHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PolicyHolderServiceImpl implements PolicyHolderService {
    @Autowired
    private PolicyHolderMapper policyholderMapper;

    //增
    public int add(PolicyHolder policyholder) {
        return policyholderMapper.add(policyholder);
    }

    //删
    public int delete(PolicyHolder policyholder) {
        return policyholderMapper.delete(policyholder);
    }

    //改
    public int update(PolicyHolder policyholder) {
        return policyholderMapper.update(policyholder);
    }

    //查所有
    public List<PolicyHolder> findAll() {
        return policyholderMapper.findAll();
    }

    //查单条
    public PolicyHolder findOne(PolicyHolder policyholder) {
        return policyholderMapper.findOne(policyholder);
    }

    //多条件查询
    public List<PolicyHolder> searchOne(PolicyHolder policyholder) {
        return policyholderMapper.searchOne(policyholder);
    }

    //    批量删除
    public int batchDelete(String[] phid) {
        return policyholderMapper.batchDelete(phid);
    }


     //     分页
    public List<PolicyHolder> findOneSelf(PolicyHolder policyholder) {
        return policyholderMapper.findOneSelf(policyholder);
    }
}
