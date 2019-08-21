package com.java.service.impl;

import com.java.mapper.LpMapper;
import com.java.pojo.Lp;
import com.java.service.LpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpServiceImpl implements LpService {
    @Autowired
    private LpMapper lpMapper;


    @Override
    public int insertLp(Lp lp) {
        return lpMapper.insertLp(lp);
    }

    @Override
    public int updateLp(Lp lp) {
        return lpMapper.updateLp(lp);
    }

    @Override
    public List<Lp> findLp(Lp lp) {
        return lpMapper.findLp(lp);
    }
}
