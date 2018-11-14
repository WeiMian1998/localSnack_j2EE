package cn.edu.hziee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.mapper.UserInfoMapper;
import cn.edu.hziee.model.ShopInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.AirInfoService;
import cn.edu.hziee.service.ShopInfoService;

@Controller
@RequestMapping("/shop")
public class ShopInfoController extends BaseController {
	@Autowired
	private ShopInfoService shopInfoService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	//显示商户
	@RequestMapping(value="/findShop",method=RequestMethod.POST)
	public String getUserInfo(HttpServletRequest request,HttpServletResponse response){
		/*String token = request.getParameter("token");*/
		
		//int s = 1;
		return null;
	}
	//添加商户
	@RequestMapping(value="/addShop",method=RequestMethod.POST)
	public String addShop(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		UserInfo u = new UserInfo();
		u = userInfoMapper.findByToken(token);
		
		String shopName = request.getParameter("shop_name");
		String shopAddress = request.getParameter("shop_address");
		String shopTelphone = request.getParameter("shop_telphone");
		String officeHours = request.getParameter("office_hours");
		int userId = u.getUserId();
		String content = request.getParameter("content");
		int areaId = Integer.valueOf(request.getParameter("area_id"));
		
		ShopInfo shop = shopInfoService.addShop(shopName,shopAddress,shopTelphone,officeHours,userId,content,areaId);
		int s = 1;
		return ajaxReturn(response,s , "add success", shop);
	}
	
	@RequestMapping("/showMyShop")
	public String showMyShop(HttpServletRequest request,HttpServletResponse response){

		String token = request.getParameter("token");
		List<?>list = shopInfoService.showMyShop(token);

		return ajaxReturn(response,1,"success",list);
	}


	@RequestMapping("showArea")

	public String showArea(HttpServletRequest request,HttpServletResponse response){

		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = shopInfoService.showArea(shopId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showAir")

	public String showAir(HttpServletRequest request,HttpServletResponse response){

		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = shopInfoService.showAir(shopId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showCuisine")

	public String showCuisine(HttpServletRequest request,HttpServletResponse response){

		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = shopInfoService.showCuisine(shopId);

		return ajaxReturn(response,1,"success",list);
	}
	
	@RequestMapping(value="/updateBase",method=RequestMethod.POST)
	public String updateBase(HttpServletRequest request,HttpServletResponse response){
		String shopId = request.getParameter("shop_id");		
		String shopName = request.getParameter("shop_name");
		String shopAddress = request.getParameter("shop_address");
		String shopTelphone = request.getParameter("shop_telphone");
		String officeHours = request.getParameter("office_hours");
		String content = request.getParameter("content");
		int areaId = Integer.valueOf(request.getParameter("area_id"));
		
		ShopInfo shop = shopInfoService.updateShop(shopId,shopName,shopAddress,shopTelphone,officeHours,content,areaId);
		int s = 1;
		return ajaxReturn(response,s , "update success", shop);
	}
	
	@RequestMapping(value="/updateImg",method=RequestMethod.POST)
	public String updateImg(HttpServletRequest request,HttpServletResponse response){
		String shopId = request.getParameter("shop_id");		
		String shopImg = request.getParameter("shop_img");
		
		ShopInfo shop = shopInfoService.updateImg(shopId,shopImg);
		int s = 1;
		return ajaxReturn(response,s , "update img success", shop);
	}

	@RequestMapping("findByShopId")

	public String findByShopId(HttpServletRequest request,HttpServletResponse response){

		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = shopInfoService.findByShopId(shopId);
		
		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("findByShopName")

	public String findByShopName(HttpServletRequest request,HttpServletResponse response){

		String keyword = request.getParameter("keyword");
		List<?>list = shopInfoService.findByShopName(keyword);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("findByAreaId")

	public String findByAreaId(HttpServletRequest request,HttpServletResponse response){

		int areaId =Integer.valueOf( request.getParameter("area_id"));
		List<?>list = shopInfoService.findByAreaId(areaId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("findByAirId")

	public String findByAirId(HttpServletRequest request,HttpServletResponse response){

		int airId =Integer.valueOf( request.getParameter("air_id"));
		List<?>list = shopInfoService.findByAirId(airId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("findByCuisineId")

	public String findByCuisineId(HttpServletRequest request,HttpServletResponse response){

		int cuisineId =Integer.valueOf( request.getParameter("cuisine_id"));
		List<?>list = shopInfoService.findByCuisineId(cuisineId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showScore")

	public String showScore(HttpServletRequest request,HttpServletResponse response){

		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = shopInfoService.showScore(shopId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showHotShop")

	public String showHotShop(HttpServletRequest request,HttpServletResponse response){

		List<?>list = shopInfoService.showHotShop();

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showHotByCuisine")

	public String showHotByCuisine(HttpServletRequest request,HttpServletResponse response){

		int cuisineId =Integer.valueOf( request.getParameter("cuisine_id"));
		List<?>list = shopInfoService.showHotByCuisine(cuisineId);

		return ajaxReturn(response,1,"success",list);
	}

}
