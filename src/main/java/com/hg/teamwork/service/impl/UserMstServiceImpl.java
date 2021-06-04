package com.hg.teamwork.service.impl;

import com.hg.teamwork.rds.mapper.UserMstMapper;
import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.rds.model.UserMstExample;
import com.hg.teamwork.service.UserMstService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ying
 * @date 2021/06/03
 */
@Service
public class UserMstServiceImpl implements UserMstService {

    @Resource
    UserMstMapper userMstMapper;

    @Override
    public UserMst selectUserByLoginName(String loginName) {
        UserMstExample userMstExample = new UserMstExample();
        userMstExample.or().andLoginNameEqualTo(loginName);
        List<UserMst> userMsts = userMstMapper.selectByExample(userMstExample);
        UserMst userMst = null;
        if (userMsts.size() > 0) {
            userMst = userMsts.get(0);
        }
        return userMst;
    }

    @Override
    public void userInsert(UserMst userMst) {
        userMstMapper.insertSelective(userMst);
    }

    @Override
    public void userUpdate(UserMst userMst) {
        userMstMapper.updateByPrimaryKeySelective(userMst);
    }
}
