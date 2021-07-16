package com.hg.teamwork.service;

import com.hg.teamwork.common.response.DataView;
import com.hg.teamwork.controller.form.PageLimit;
import com.hg.teamwork.rds.model.LearningMaterials;

/**
 * @author ying
 * @date 2021/06/23
 */
public interface MaterialsService {

    /**
     * 获取资料
     *
     * @param learningMaterials
     * @param pageLimit
     * @return
     */
    DataView getMaterialsList(LearningMaterials learningMaterials, PageLimit pageLimit);

    /**
     * 资料表插入
     *
     * @param learningMaterials
     */
    int materialsInsert(LearningMaterials learningMaterials);

    /**
     * 根据id查询资料
     * @param id
     * @return
     */
    LearningMaterials getMaterials(Integer id);
}
