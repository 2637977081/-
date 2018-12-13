package com.univer.account.mapper;

import com.univer.account.po.Func;
import com.univer.account.vo.FuncVo;
import com.univer.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 功能相关接口
 * @author hongjiao
 */
public interface FuncMapper extends BaseMapper<Func> {
    /**
     * 查询该父级下最大的序号
     * @param parentId
     * @return Long
     */
    Long selectMaxNumber(Long parentId);

    /**
     * 根据用户和状态获取功能po列表
     * @param userId
     * @param status
     * @return List<Func>
     */
    List<Func> getFuncByUserId(@Param("userId") Long userId, @Param("status") String status);

    /**
     * 根据用户和状态获取功能vo列表
     * @param userId
     * @param status
     * @return List<FuncVo>
     */
    List<FuncVo> getFuncVoByUserId(@Param("userId") Long userId, @Param("status") String status);
    /**
     * 根据角色和状态获取功能列表
     * @param roleId
     * @param status
     * @return List<Func>
     */
    List<Func> selectByRoleId(@Param("roleId") Long roleId, @Param("status")String status);
 }