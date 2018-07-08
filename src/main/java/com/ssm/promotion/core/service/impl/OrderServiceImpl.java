package com.ssm.promotion.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.OrderDao;
import com.ssm.promotion.core.dao.QuestionBankDao;
import com.ssm.promotion.core.dto.OrderTUserDto;
import com.ssm.promotion.core.entity.TOrder;
import com.ssm.promotion.core.service.OrderService;
/**
 * @author 刘家霖
 * @project_name perfect-ssm
 * @date 2018-7-7
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao ;
	@Override
	public List<OrderTUserDto> findPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDao.findPage(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDao.getTotal(map);
	}

	@Override
	public int update(TOrder torder) {
		// TODO Auto-generated method stub
		return orderDao.update(torder);
	}

}
