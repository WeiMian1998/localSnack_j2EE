package cn.edu.hziee.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.mapper.ReviewInfoMapper;
import cn.edu.hziee.mapper.UserInfoMapper;
import cn.edu.hziee.model.ReviewInfo;
import cn.edu.hziee.model.ShopInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.ReviewInfoService;
import cn.edu.hziee.service.UserInfoService;

@Controller
@RequestMapping("review_info")
public class ReviewInfoController extends BaseController {

	@Autowired
	ReviewInfoService reviewInfoService;
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@RequestMapping(value="/addReview",method=RequestMethod.POST)
	public String addReview(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		UserInfo u = new UserInfo();
		u = userInfoMapper.findByToken(token);
		
		String shopId = request.getParameter("shop_id");
		int userId = u.getUserId();
		String reviewContent = request.getParameter("review_content");
		double taste = Double.valueOf(request.getParameter("taste"));
		double environment = Double.valueOf(request.getParameter("environment"));
		double service = Double.valueOf(request.getParameter("service"));
		double reviewScore = Double.valueOf(request.getParameter("review_score"));
		
		ReviewInfo ri = reviewInfoService.addReview(userId,shopId,reviewContent,taste,environment,service,reviewScore);
		int s = 1;
		return ajaxReturn(response,s , "add success", ri);
	}
	
	


	@RequestMapping("ReviewList")

	public String ReviewList(HttpServletRequest request,HttpServletResponse response){

		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = reviewInfoService.ReviewList(shopId);

		return ajaxReturn(response,1,"success",list);
	}




	@RequestMapping("showReviewList")

	public String showReviewList(HttpServletRequest request,HttpServletResponse response){

		int userId =Integer.valueOf(request.getParameter("user_id"));
		List<?>list = reviewInfoService.showReviewList(userId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showNewReview")

	public String showNewReview(HttpServletRequest request,HttpServletResponse response){

		List<?>list = reviewInfoService.showNewReview();

		return ajaxReturn(response,1,"success",list);
	}
	@RequestMapping(value="/updateReview",method=RequestMethod.POST)
	public String updateReview(HttpServletRequest request,HttpServletResponse response){
		
		int reviewId = Integer.valueOf(request.getParameter("review_id"));
		String reviewContent = request.getParameter("review_content");
		double taste = Double.valueOf(request.getParameter("taste"));
		double environment = Double.valueOf(request.getParameter("environment"));
		double service = Double.valueOf(request.getParameter("service"));
		double reviewScore = Double.valueOf(request.getParameter("review_score"));
		double avg = Double.valueOf(request.getParameter("avg"));
		
		ReviewInfo ri = reviewInfoService.updateReview(reviewId,reviewContent,taste,environment,avg,service,reviewScore);
		int s = 1;
		return ajaxReturn(response,s , "update success", ri);
	}
	@RequestMapping(value="/deleteReview",method=RequestMethod.POST)
	public String deleteReview(HttpServletRequest request,HttpServletResponse response){
		
		int reviewId = Integer.valueOf(request.getParameter("review_id"));
		
		String ri = reviewInfoService.deleteReview(reviewId);
		int s = 1;
		return ajaxReturn(response,s , "delete success", null);
	}
	@RequestMapping("findMyReview")

	public String findMyReview(HttpServletRequest request,HttpServletResponse response){

		int userId =Integer.valueOf(request.getParameter("user_id"));
		int shopId =Integer.valueOf( request.getParameter("shop_id"));
		List<?>list = reviewInfoService.findMyReview(userId,shopId);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("findReviewByUserId")

	public String findReviewByUserId(HttpServletRequest request,HttpServletResponse response){

		int userId =Integer.valueOf(request.getParameter("user_id"));
		List<?>list = reviewInfoService.findReviewByUserId(userId);

		return ajaxReturn(response,1,"success",list);
	}
	@RequestMapping("showUserReview")

	public String showUserReview(HttpServletRequest request,HttpServletResponse response){

		int userId =Integer.valueOf(request.getParameter("user_id"));
		List<?>list = reviewInfoService.showUserReview(userId);

		return ajaxReturn(response,1,"success",list);
	}

}
