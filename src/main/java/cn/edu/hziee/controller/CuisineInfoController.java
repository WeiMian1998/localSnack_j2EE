package cn.edu.hziee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.model.CuisineInfo;
import cn.edu.hziee.service.CuisineInfoService;

@Controller
@RequestMapping("/cuisine")
public class CuisineInfoController extends BaseController {
	@Autowired
	private CuisineInfoService cuisineInfoService;
	
	@RequestMapping(value="/addCuisine",method=RequestMethod.POST)
	public String addCuisine(HttpServletRequest request,HttpServletResponse response){
		String shopId = request.getParameter("shop_id");
		String cuisineIds = request.getParameter("cuisine_id");
		System.out.println("!!!!!!!!"+cuisineIds);
		String[] result = cuisineIds.split(",");
		CuisineInfo ci = new CuisineInfo();
		for(int i=0;i<result.length;i++){
			String cuisineId = result[i];
			ci = cuisineInfoService.addCuisine(Integer.valueOf(shopId),cuisineId);
		}
		return ajaxReturn(response,1 , "add success", null);
		}
	
	@RequestMapping(value="/updateCuisine",method=RequestMethod.POST)
	public String updateCuisine(HttpServletRequest request,HttpServletResponse response){
		String shopId = request.getParameter("shop_id");
		String cuisineIds = request.getParameter("cuisine_id");
		String[] result = cuisineIds.split(",");
		CuisineInfo ci = new CuisineInfo();
		ci = cuisineInfoService.updateCuisine(Integer.valueOf(shopId));
		for(int i=0;i<result.length;i++){
			String cuisineId = result[i];
			ci = cuisineInfoService.addCuisine(Integer.valueOf(shopId),cuisineId);
		}
		return ajaxReturn(response,1 , "update success", null);
		}
}
