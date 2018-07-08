package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.OrderTUserDto;
import com.ssm.promotion.core.entity.QuestionBank;
import com.ssm.promotion.core.entity.SRole;
import com.ssm.promotion.core.entity.TOrder;

/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-7
 */
public interface OrderDao {
	 /**
     * 订单分页
     *
     * @param map
     * @return
     */
    public List<OrderTUserDto> findPage(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotal(Map<String, Object> map);
    /**
     * 修改
     *
     * @param questionBank
     * @return
     */
    public int update(TOrder torder );
}
