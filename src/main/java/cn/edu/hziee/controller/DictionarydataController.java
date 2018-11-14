package cn.edu.hziee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hziee.service.DictionarydataService;

@Controller
@RequestMapping("/dictionary")
public class DictionarydataController extends BaseController{
	
	@Autowired
	private DictionarydataService dictionarydataService;
	
	@RequestMapping(value="/find_by_parent_id",method=RequestMethod.POST)
	public String findByParentId(HttpServletRequest request,HttpServletResponse response){
		String pid = request.getParameter("pid");
		
		List<?> d =dictionarydataService.findByParentId(Integer.valueOf(pid));
		
		return ajaxReturn(response,1 , "success", d);
	}


}
