package cn.edu.hziee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.mapper.UserInfoMapper;
import cn.edu.hziee.model.CollectionInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.CollectionInfoService;

@Controller
@RequestMapping("Collection_info")
public class CollectionInfoController extends BaseController{
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	CollectionInfoService collectionInfoService;
	
	@RequestMapping(value="/addCollection",method=RequestMethod.POST)
	public String addCollection(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		UserInfo u = new UserInfo();
		u = userInfoMapper.findByToken(token);
		
		int shopId = Integer.valueOf(request.getParameter("shop_id"));
		int userId = u.getUserId();
		
		CollectionInfo ci =  collectionInfoService.addCollection(shopId,userId);
		
		return ajaxReturn(response,1 , "add success", ci);
	}
	

	@RequestMapping("showCollection")

	public String showCollection(HttpServletRequest request,HttpServletResponse response){

		int userId = Integer.valueOf(request.getParameter("user_id"));
		List<?>list = collectionInfoService.showCollection(userId);

		return ajaxReturn(response,1,"success",list);
	}
	
	@RequestMapping(value="/deleteCol",method=RequestMethod.POST)
	public String deleteCol(HttpServletRequest request,HttpServletResponse response){
		
		int colId = Integer.valueOf(request.getParameter("col_id"));
		
		String ci =  collectionInfoService.deleteCol(colId);
		
		return ajaxReturn(response,1 , "add success", ci);
	}

	@RequestMapping("showColState")
	public String showColState(HttpServletRequest request,HttpServletResponse response){

		int userId = Integer.valueOf(request.getParameter("user_id"));
		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = collectionInfoService.showColState(userId,shopId);

		return ajaxReturn(response,1,"success",list);
	}
	@RequestMapping("showCollectionList")

	public String showCollectionList(HttpServletRequest request,HttpServletResponse response){

		int userId = Integer.valueOf(request.getParameter("user_id"));
		List<?>list = collectionInfoService.showCollectionList(userId);

		return ajaxReturn(response,1,"success",list);
	}

}
