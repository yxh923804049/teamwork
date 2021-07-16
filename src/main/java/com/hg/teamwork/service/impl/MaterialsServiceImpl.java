package com.hg.teamwork.service.impl;

import com.github.pagehelper.PageHelper;
import com.hg.teamwork.common.response.DataView;
import com.hg.teamwork.controller.form.PageLimit;
import com.hg.teamwork.controller.vo.MaterialsVo;
import com.hg.teamwork.rds.mapper.LearningMaterialsMapper;
import com.hg.teamwork.rds.mapper.UserMstMapper;
import com.hg.teamwork.rds.model.LearningMaterials;
import com.hg.teamwork.rds.model.LearningMaterialsExample;
import com.hg.teamwork.rds.model.UserMst;
import com.hg.teamwork.service.MaterialsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialsServiceImpl implements MaterialsService {

    @Resource
    LearningMaterialsMapper learningMaterialsMapper;

    @Resource
    UserMstMapper userMstMapper;

    @Override
    public DataView getMaterialsList(LearningMaterials learningMaterials, PageLimit pageLimit) {
        LearningMaterialsExample learningMaterialsExample = new LearningMaterialsExample();
        LearningMaterialsExample.Criteria criteria = learningMaterialsExample.createCriteria();
        if (learningMaterials.getProfileName() != null) {
            criteria.andProfileNameLike("%" + learningMaterials.getProfileName() + "%");
        }
        if (learningMaterials.getUserId() != null) {
            criteria.andUserIdEqualTo(learningMaterials.getUserId());
        }
        if (pageLimit.getPage() != null && pageLimit.getLimit() != null) {
            PageHelper.startPage(pageLimit.getPage(), pageLimit.getLimit());
        }
        List<LearningMaterials> learningMaterialsList = learningMaterialsMapper.selectByExample(learningMaterialsExample);
        List<MaterialsVo> materialsVos = new ArrayList<>();
        BeanUtils.copyProperties(learningMaterialsList, materialsVos);
        for (int i = 0; i < learningMaterialsList.size(); i++) {
            MaterialsVo materialsVo = new MaterialsVo();
            BeanUtils.copyProperties(learningMaterialsList.get(i), materialsVo);
            UserMst userMst = userMstMapper.selectByPrimaryKey((long) learningMaterialsList.get(i).getUserId());
            if (userMst != null) {
                materialsVo.setUserName(userMst.getUserName());
            }
            materialsVos.add(materialsVo);
        }
        DataView dataView = new DataView();
        dataView.setCount(materialsVos.size());
        dataView.setData(materialsVos);
        if (learningMaterialsList.size() == 0) {
            dataView.setMsg("查询不到该数据");
        } else {
            dataView.setMsg("查询成功");
        }
        return dataView;
    }

    @Override
    public int materialsInsert(LearningMaterials learningMaterials) {
        return learningMaterialsMapper.insertSelective(learningMaterials);
    }

    @Override
    public LearningMaterials getMaterials(Integer id) {
        return learningMaterialsMapper.selectByPrimaryKey(id);
    }
}
