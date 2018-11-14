package cn.edu.hziee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.mapper.UserInfoMapper;
import cn.edu.hziee.model.ImgInfo;
import cn.edu.hziee.model.ReviewInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.ImgInfoService;
import cn.edu.hziee.service.UserInfoService;

@Controller
@RequestMapping("img_info")
public class ImgInfoController extends BaseController {
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	ImgInfoService imgInfoService;
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@RequestMapping(value="/addImg",method=RequestMethod.POST)
	public String addImg(HttpServletRequest request,HttpServletResponse response){
		
		int reviewId = Integer.valueOf(request.getParameter("review_id"));
		String img = request.getParameter("img");
		int shopId = Integer.valueOf(request.getParameter("shop_id"));
		
		ImgInfo im = imgInfoService.addImg(reviewId,img,shopId);
		int s = 1;
		return ajaxReturn(response,s , "add success", im);
	}

	@RequestMapping(value="/updateImg",method=RequestMethod.POST)
	public String updateImg(HttpServletRequest request,HttpServletResponse response){
		
		int imgId = Integer.valueOf(request.getParameter("img_id"));
		String img = request.getParameter("img");
		
		ImgInfo im = imgInfoService.updateImg(imgId,img);
		int s = 1;
		return ajaxReturn(response,s , "update success", im);
	}	@RequestMapping("showImg")

	public String showImg(HttpServletRequest request,HttpServletResponse response){

		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		int reviewId =Integer.valueOf( request.getParameter("review_id"));
		List<?>list = imgInfoService.showImg(shopId,reviewId);

		return ajaxReturn(response,1,"success",list);
	}

}
