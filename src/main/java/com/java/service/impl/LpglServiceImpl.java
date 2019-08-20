package com.java.service.impl;

import com.java.mapper.LpglMapper;
import com.java.pojo.Lpgl;
import com.java.service.LpglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpglServiceImpl implements LpglService {
    @Autowired
    private LpglMapper lpglMapper;

    @Override
    public int insertLpgl(Lpgl lpgl) {
        return lpglMapper.insertLpgl(lpgl);
    }

    @Override
    public int deleteLpgl(Integer id) {
        return lpglMapper.deleteLpgl(id);
    }

    @Override
    public int deleteLpgls(List<Integer> list) {
        return lpglMapper.deleteLpgls(list);
    }

    @Override
    public int updateLpgl(Lpgl lpgl) {
        return lpglMapper.updateLpgl(lpgl);
    }

    @Override
    public List<Lpgl> findBy(Integer id, String ss, String desc, String ord) {
        return lpglMapper.findBy(id, ss, desc, ord);
    }

}
