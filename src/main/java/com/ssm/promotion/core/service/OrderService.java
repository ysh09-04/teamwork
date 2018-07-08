package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.OrderTUserDto;
import com.ssm.promotion.core.entity.TOrder;

public interface OrderService {
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
