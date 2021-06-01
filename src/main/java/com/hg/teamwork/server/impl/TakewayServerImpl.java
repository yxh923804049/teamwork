package com.hg.teamwork.server.impl;

import com.hg.teamwork.mapper.TakewayMapper;
import com.hg.teamwork.model.Takeway;
import com.hg.teamwork.server.TakewayServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TakewayServerImpl implements TakewayServer {

    @Resource
    TakewayMapper takewayMapper;

    @Override
    public void insert(Takeway takeway) {
        takewayMapper.insertSelective(takeway);
    }

    @Override
    public Takeway select() {
        return takewayMapper.select();
    }

    @Override
    public int selectCount(String name) {
        return takewayMapper.selectCount(name);
    }
}
