package com.univer.account.mapper;

import com.univer.account.po.Dict;
import com.univer.account.vo.DictVo;
import com.univer.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典相关接口
 * @author hongjiao
 */
public interface DictMapper extends BaseMapper<Dict> {
    /**
     * 根据type字段查询name、value 组合成map
     * @param type
     * @return
     */
    List<DictVo> findMapByType(@Param("type") String type);

}