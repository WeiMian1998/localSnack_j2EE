package cn.edu.hziee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.model.OrderInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.OrderInfoService;
import cn.edu.hziee.service.UserInfoService;

@Controller
@RequestMapping("/order_info")
public class OrderInfoController extends BaseController{
	@Autowired
	OrderInfoService orderInfoService;
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping(value="/addOrder",method=RequestMethod.POST)
	public String addOrder(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		UserInfo u = userInfoService.findUser(token);
		
		String orderTime = request.getParameter("order_time");
		String orderNum = request.getParameter("order_num");
		String orderType = request.getParameter("order_type");
		String orderDetails = request.getParameter("order_details");
		String shopId = request.getParameter("shop_id");
		int userId = u.getUserId();
		OrderInfo oi = orderInfoService.addOrder(userId,shopId,orderTime,orderNum,orderType,orderDetails);
		int s = 1;
		return ajaxReturn(response,s , "", oi);
	}
	
	@RequestMapping("deleteOrder")
	public String deleteOrder(HttpServletRequest request,HttpServletResponse response){

		int orderId =Integer.valueOf( request.getParameter("order_id"));
		OrderInfo oi = orderInfoService.deleteOrder(orderId);

		return ajaxReturn(response,1,"delete success",oi);
	}


	@RequestMapping("showOrder")

	public String showOrder(HttpServletRequest request,HttpServletResponse response){

		String token = request.getParameter("token");
		List<?>list = orderInfoService.showOrder(token);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showShopOrder")

	public String showShopOrder(HttpServletRequest request,HttpServletResponse response){

		String shopId = request.getParameter("shop_id");
		List<?>list = orderInfoService.showShopOrder(shopId);

		return ajaxReturn(response,1,"success",list);
	}
	
	@RequestMapping("RightOrderByShop")
	public String RightOrderByShop(HttpServletRequest request,HttpServletResponse response){

		int orderId =Integer.valueOf( request.getParameter("order_id"));
		OrderInfo oi = orderInfoService.RightOrderByShop(orderId);
		return ajaxReturn(response,1,"order right success",oi);
	}
	
	@RequestMapping("deleteRecord")
	public String deleteRecord(HttpServletRequest request,HttpServletResponse response){

		int orderId =Integer.valueOf( request.getParameter("order_id"));
		OrderInfo oi = orderInfoService.deleteRecord(orderId);

		return ajaxReturn(response,1,"delete success",oi);
	}

}
