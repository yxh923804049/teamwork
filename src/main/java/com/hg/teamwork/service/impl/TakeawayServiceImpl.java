package com.hg.teamwork.service.impl;

import com.hg.teamwork.mapper.TakeawayMapper;
import com.hg.teamwork.model.Takeaway;
import com.hg.teamwork.model.TakeawayExample;
import com.hg.teamwork.service.TakeawayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ying
 * @date 2021/06/02
 */
@Service
public class TakeawayServiceImpl implements TakeawayService {

    @Resource
    TakeawayMapper takeawayMapper;

    @Override
    public void takeawayInsert(Takeaway takeaway) {
        takeawayMapper.insertSelective(takeaway);
    }

    @Override
    public Takeaway takeawaySelect() {
        TakeawayExample takeawayExample = new TakeawayExample();
        takeawayExample.setOrderByClause("time desc");
        List<Takeaway> takeaways = takeawayMapper.selectByExample(takeawayExample);
        if (takeaways.size() > 0) {
            return takeaways.get(0);
        }
        return null;
    }

    @Override
    public int takeawayCount(String name) {
        TakeawayExample takeawayExample = new TakeawayExample();
        takeawayExample.or().andNameEqualTo(name);
        return (int) takeawayMapper.countByExample(takeawayExample);
    }
}
