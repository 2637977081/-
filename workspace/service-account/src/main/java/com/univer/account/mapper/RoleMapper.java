package com.univer.account.mapper;

import com.univer.account.po.Role;
import com.univer.account.vo.RoleVo;
import com.univer.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hongjiao
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户查询角色
     * @param userId
     * @param status
     * @return List<RoleVo>
     */
    List<RoleVo> getRoleByUserId(@Param("userId") Long userId,@Param("status") String status);

    /**
     * 根据角色名获取列表（包含角色的用户数）
     * @param name
     * @param status
     * @return List<RoleVo>
     */
    List<RoleVo> findRoleList(@Param("name") String name,@Param("status") String status);

    /**
     * 查询用户是否拥有角色
     * @param code
     * @param userId
     * @return
     */
    Integer countByCodeAndUserId(@Param("code") String code,@Param("userId") Long userId);
}