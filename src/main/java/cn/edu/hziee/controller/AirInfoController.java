package cn.edu.hziee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.model.AirInfo;
import cn.edu.hziee.model.ShopInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.AirInfoService;
import cn.edu.hziee.service.ShopInfoService;
import cn.edu.hziee.service.UserInfoService;

@Controller
@RequestMapping("/airInfo")
public class AirInfoController extends BaseController {
	@Autowired
	private AirInfoService airInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private ShopInfoService shopInfoService;
	
	@RequestMapping(value="/addAirInfo",method=RequestMethod.POST)
	public String addAirInfo(HttpServletRequest request,HttpServletResponse response){
		String shopId = request.getParameter("shop_id");
		String airIds = request.getParameter("air_id");
		String[] result = airIds.split(",");
		AirInfo air = new AirInfo();
		for(int i=0;i<result.length;i++){
			String airId = result[i];
			air = airInfoService.addAir(Integer.valueOf(shopId),airId);
		}
		return ajaxReturn(response,1 , "add success", null);
		}
	
	@RequestMapping(value="/updateAirInfo",method=RequestMethod.POST)
	public String updateAirInfo(HttpServletRequest request,HttpServletResponse response){
		String shopId = request.getParameter("shop_id");
		String airIds = request.getParameter("air_id");
		String[] result = airIds.split(",");
		AirInfo air = new AirInfo();
		air = airInfoService.deleteAir(Integer.valueOf(shopId));
		for(int i=0;i<result.length;i++){
			String airId = result[i];
			air = airInfoService.addAir(Integer.valueOf(shopId),airId);
		}
		return ajaxReturn(response,1 , "update success", null);
		}



}
