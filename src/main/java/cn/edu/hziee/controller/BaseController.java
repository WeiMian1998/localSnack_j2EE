package cn.edu.hziee.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class BaseController {
	
	
	
	public String ajaxReturn(HttpServletResponse response,int stauts,String info,Object obj){
		response.setContentType("text/html;charset=UTF-8"); 
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stauts", stauts);
		map.put("data", obj);
		map.put("info", info);
		try {
			PrintWriter out= response.getWriter();
			out.print(JSON.toJSONString(map));
			System.out.println(JSON.toJSONString(map));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}
	public String ajaxReturn(HttpServletResponse response,String info) {
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(info);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}
	public String ajaxReturn(HttpServletResponse response,HashMap<String,Object>obj){
		try{
			
			response.setContentType("text/html;charset=UTF-8"); 
	
			String info2 = JSONArray.toJSONString(obj);
			
			PrintWriter out= response.getWriter();
			
			out.print(info2);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void show(Object...objects) {
		System.out.println("!!!!!!!!!!!!");
		for(Object o:objects) {
			System.out.println(o);
		}
		System.out.println("!!!!!!!!!!!!");
	}
	 
	
}
