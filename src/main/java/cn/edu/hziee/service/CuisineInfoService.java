package cn.edu.hziee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.edu.hziee.mapper.CuisineInfoMapper;
import cn.edu.hziee.model.CuisineInfo;

@Service
public class CuisineInfoService {
	@Autowired
	private CuisineInfoMapper cuisineInfoMapper;
	
	public CuisineInfo addCuisine(Integer shopId, String cuisineId) {
		// TODO Auto-generated method stub
		CuisineInfo ci = new CuisineInfo();
/*		System.out.println("!!!!"+airId);*/
		ci.setCuisineId(Integer.valueOf(cuisineId));
		ci.setShopId(shopId);
		
		cuisineInfoMapper.insert(ci);
		return null;
	}

	public CuisineInfo updateCuisine(Integer valueOf) {
		// TODO Auto-generated method stub
		cuisineInfoMapper.deleteByShopId(valueOf);
		return null;
	}
}
