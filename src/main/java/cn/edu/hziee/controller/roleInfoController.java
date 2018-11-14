package cn.edu.hziee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.model.RoleInfo;
import cn.edu.hziee.model.UserInfo;
import cn.edu.hziee.service.RoleInfoService;

@Controller
@RequestMapping("/role_info")
public class roleInfoController extends BaseController{
	@Autowired
	RoleInfoService roleInfoService;
	
	@RequestMapping(value="/roleLogin",method=RequestMethod.POST)
	public String roleLogin(HttpServletRequest request,HttpServletResponse response){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		RoleInfo ri = roleInfoService.roleLogin(account,password);
		int s=1;
		if(ri == null){
			return ajaxReturn(response,s , "account or password failed", ri);
		}
		return ajaxReturn(response,s , "login sucess", ri);
	}
}
