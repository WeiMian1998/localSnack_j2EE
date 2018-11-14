package cn.edu.hziee.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController{
	@Autowired
	private UserInfoService userInfoService;
	//显示用户
	@RequestMapping(value="/findUser",method=RequestMethod.POST)
	public String getUserInfo(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		UserInfo u = userInfoService.findUser(token);
		int s = 1;
		return ajaxReturn(response,s , "", u);
	}
	//用户注册
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,HttpServletResponse response){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String userName = request.getParameter("user_name");
		
		Object info = userInfoService.register(account,password,userName);
		if(info instanceof String){
			return ajaxReturn(response,0 , info.toString(), null);
		}else{
			return ajaxReturn(response,1 , "", info);			
		}
			

	}
	//用户信息更新
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateUser(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		String realName= request.getParameter("real_name");
		String userName = request.getParameter("user_name");
		String telphone= request.getParameter("telphone");
		String sex= request.getParameter("sex");
		String address= request.getParameter("address");
		String introduce = request.getParameter("introduce");
		
		UserInfo info = userInfoService.updateUser(token,realName,userName,telphone,sex,address,introduce);
		int s = 1;
		return ajaxReturn(response,s , "", info);
	}
	//用户登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		UserInfo u = userInfoService.login(account,password);
		int s=1;
		if(u == null){
			return ajaxReturn(response,s , "account or password failed", u);
		}
		return ajaxReturn(response,s , "login sucess", u);
	}
	//上传头像
	@RequestMapping(value="/updateHead",method=RequestMethod.POST)
	public String updateHead(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		String head = request.getParameter("head_img");
		
		UserInfo u = userInfoService.updateHead(token,head);
		
		u = userInfoService.findUser(token);
		int s=1;
		return ajaxReturn(response,s,"update success",u);
		
	}
	//更新is_shop=1
	@RequestMapping(value="/shopping",method=RequestMethod.POST)
	public String shopping(HttpServletRequest request,HttpServletResponse response){
		String token = request.getParameter("token");
		
		String isShop = request.getParameter("is_shop");
		
		UserInfo info = userInfoService.shopping(token,isShop);
		int s = 1;
		return ajaxReturn(response,s , "", info);
	}	
	


	@RequestMapping("showUser")

	public String showUser(HttpServletRequest request,HttpServletResponse response){

		int first =Integer.valueOf( request.getParameter("first"));
		int each =Integer.valueOf( request.getParameter("each"));
		List<?>list = userInfoService.showUser(first,each);

		return ajaxReturn(response,1,"success",list);
	}

	@RequestMapping("showtotal")

	public String showtotal(HttpServletRequest request,HttpServletResponse response){

		List<?>list = userInfoService.showtotal();

		return ajaxReturn(response,1,"success",list);
	}
	
	//上传头像
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public String deleteUser(HttpServletRequest request,HttpServletResponse response){
		int userId = Integer.valueOf( request.getParameter("user_id"));
		
		String u = userInfoService.deleteUser(userId);
	
		int s=1;
		return ajaxReturn(response,s,"delete success",null);
		
	}
	//管理员添加用户
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(HttpServletRequest request,HttpServletResponse response){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String userName = request.getParameter("user_name");
		String realName = request.getParameter("real_name");
		String telphone = request.getParameter("telphone");
		String address = request.getParameter("address");
		
		Object info = userInfoService.addUser(account,password,userName,realName,telphone,address);
		
		return ajaxReturn(response,1 , "", info);			
	}	@RequestMapping("findByUserId")

	public String findByUserId(HttpServletRequest request,HttpServletResponse response){

		int userId = Integer.valueOf( request.getParameter("user_id"));
		List<?>list = userInfoService.findByUserId(userId);

		return ajaxReturn(response,1,"success",list);
	}
	
	//用户信息更新
	@RequestMapping(value="/updateUserByRole",method=RequestMethod.POST)
	public String updateUserByRole(HttpServletRequest request,HttpServletResponse response){
		
		int userId = Integer.valueOf( request.getParameter("user_id"));
		String realName= request.getParameter("real_name");
		String userName = request.getParameter("user_name");
		String telphone= request.getParameter("telphone");
		String address= request.getParameter("address");
		String introduce = request.getParameter("introduce");
		
		UserInfo info = userInfoService.updateUserByRole(userId,realName,userName,telphone,address,introduce);
		int s = 1;
		return ajaxReturn(response,s , "", info);
	}
}
