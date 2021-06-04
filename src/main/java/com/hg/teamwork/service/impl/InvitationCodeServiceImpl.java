package com.hg.teamwork.service.impl;

import com.hg.teamwork.rds.mapper.InvitationCodeMapper;
import com.hg.teamwork.service.InvitationCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ying
 * @date 2021/06/04
 */
@Service
public class InvitationCodeServiceImpl implements InvitationCodeService {

    @Resource
    InvitationCodeMapper invitationCodeMapper;

    @Override
    public String invitationCodeSelect() {
        return invitationCodeMapper.selectByPrimaryKey(1).getCode();
    }
}
