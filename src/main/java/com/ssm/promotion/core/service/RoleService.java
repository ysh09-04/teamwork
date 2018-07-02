package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.entity.SRole;

/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-1
 */
public interface RoleService {
	/**
     * 查找角色
     *
     * @param map
     * @return
     */
    public List<SRole> findRole(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalRole(Map<String, Object> map);
    /**
     * 添加角色
     *
     * @param srole
     * @return
     */
    public int addSRole(SRole sRole);
    /**
     * 修改角色信息
     *
     * @param srole
     * @return
     */
    public int updateSRole(SRole sRole);
    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    public int deleteSRole(Integer roleId);

}
