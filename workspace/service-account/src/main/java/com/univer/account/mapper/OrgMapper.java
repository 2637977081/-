package com.univer.account.mapper;

import com.univer.account.po.Org;
import com.univer.account.vo.OrgVo;
import com.univer.base.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author hongjiao
 */
public interface OrgMapper extends BaseMapper<Org> {
    /**
     * 查询该父级下最大的序号
     * @param parentId
     * @return Long
     */
    Long selectMaxNumber(Long parentId);

    /**
     * 条件查询
     * @param map
     * @return
     */
    List<OrgVo> selectByMap(HashMap<String,Object> map);

    /**
     * 获取所有子机构ids(方法有缺陷)
     * @param orgId
     * @return
     */
    List<Long> selectChildrenIds(Long orgId);

    /**
     * 获取所有父标签（包括自身）ids
     * @param orgId
     * @return
     */
    List<Long> selectParentIds(Long orgId);
}