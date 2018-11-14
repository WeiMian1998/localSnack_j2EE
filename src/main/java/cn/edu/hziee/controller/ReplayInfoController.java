package cn.edu.hziee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.mapper.UserInfoMapper;
import cn.edu.hziee.model.ReplayInfo;
import cn.edu.hziee.model.ReviewInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.ReplayInfoService;

@Controller
@RequestMapping("replay_info")
public class ReplayInfoController extends BaseController {
	@Autowired
	ReplayInfoService replayInfoService;
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@RequestMapping(value="/addReplay",method=RequestMethod.POST)
	public String addReplay(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		UserInfo u = new UserInfo();
		u = userInfoMapper.findByToken(token);
		int userId = u.getUserId();
		String toUserId = request.getParameter("to_user_id");
		String pid = request.getParameter("review_id");
		String content = request.getParameter("replay_content");

		
		ReplayInfo rp = replayInfoService.addReplay(userId,pid,content,toUserId);
		return ajaxReturn(response,1 , "add success", rp);
	}
	
	@RequestMapping("replayList")
	public String replayList(HttpServletRequest request,HttpServletResponse response){
		int reviewId =Integer.valueOf( request.getParameter("review_id"));
		System.out.println("!!!!!"+reviewId);
		List<?>list = replayInfoService.replayList(reviewId);
		show(list);
		return ajaxReturn(response,1,"success",list);
	}
	
	@RequestMapping(value="/addReplayAgain",method=RequestMethod.POST)
	public String addReplayAgain(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		UserInfo u = new UserInfo();
		u = userInfoMapper.findByToken(token);
		int userId = u.getUserId();
		String toUserId = request.getParameter("to_user_id");
		String pid = request.getParameter("review_id");
		String content = request.getParameter("replay_content");

		
		ReplayInfo rp = replayInfoService.addReplayAgain(userId,pid,content,toUserId);
		return ajaxReturn(response,1 , "add success", rp);
	}
}
