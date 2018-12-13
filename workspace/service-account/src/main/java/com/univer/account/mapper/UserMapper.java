package com.univer.account.mapper;

import com.univer.account.po.User;
import com.univer.account.vo.UserVo;
import com.univer.base.mapper.BaseMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author guwei
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据条件查询用户
     * @param map 条件参数
     * @return
     */
    List<UserVo> selectUserVoByCondition(Map<String, Object> map);

    /**
     * 根据OrgId查询用户
     * @param map 条件参数
     * @return
     */
    List<UserVo> selectUserVoByOrgId(Map<String, Object> map);
}