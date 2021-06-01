package com.hg.teamwork.server;

import com.hg.teamwork.model.Takeway;

public interface TakewayServer {
    void insert(Takeway takeway);
    Takeway select();
    int selectCount(String name);
}
