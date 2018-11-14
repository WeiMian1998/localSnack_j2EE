package cn.edu.hziee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hziee.mapper.OrderInfoMapper;
import cn.edu.hziee.model.OrderInfo;

@Service
@Transactional
public class OrderInfoService {
	@Autowired
	OrderInfoMapper mapper;

	public OrderInfo addOrder(int userId, String shopId, String orderTime, String orderNum, String orderType,
			String orderDetails) {
		// TODO Auto-generated method stub
		
		OrderInfo oi = new OrderInfo();
		
		oi.setOrderDetails(orderDetails);
		oi.setOrderNum(Integer.valueOf(orderNum));
		oi.setOrderState("2");
		oi.setOrderTime(orderTime);
		oi.setOrderType(Integer.valueOf(orderType));
		oi.setShopId(Integer.valueOf(shopId));
		String sendTime = System.currentTimeMillis()+"";
		oi.setSendTime(sendTime);
		oi.setUserId(Integer.valueOf(userId));
		
		mapper.insert(oi);
		
		return oi;
	}


	public OrderInfo deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		OrderInfo oi = new OrderInfo();
		oi.setOrderState("0");
		oi.setOrderId(orderId);
		mapper.changeState(oi);
		return oi;
	}


	public List<?> showOrder(String token) {
		return mapper.showOrder(token);
	}

	public List<?> showShopOrder(String shopId) {
		return mapper.showShopOrder(shopId);
	}


	public OrderInfo deleteOrderByShop(int orderId) {
		// TODO Auto-generated method stub
		
		return null;
	}


	public OrderInfo RightOrderByShop(int orderId) {
		// TODO Auto-generated method stub
		OrderInfo oi = new OrderInfo();
		oi.setOrderState("1");
		oi.setOrderId(orderId);
		mapper.changeState(oi);
		return oi;
	}


	public OrderInfo deleteRecord(int orderId) {
		// TODO Auto-generated method stub
		OrderInfo oi = new OrderInfo();
		oi.setOrderState("4");
		oi.setOrderId(orderId);
		mapper.changeState(oi);
		return oi;
	}

}