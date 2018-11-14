package cn.edu.hziee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.mapper.AirInfoMapper;
import cn.edu.hziee.mapper.ShopInfoMapper;
import cn.edu.hziee.model.AirInfo;
@Service
public class AirInfoService {
	@Autowired
	private AirInfoMapper airInfoMapper;

	public AirInfo addAir(Integer shopId, String airId) {
		// TODO Auto-generated method stub
		AirInfo air = new AirInfo();
		System.out.println("!!!!"+airId);
		air.setAirId(Integer.valueOf(airId));
		air.setShopId(shopId);
		
		airInfoMapper.insert(air);
		return null;
	}

	public AirInfo deleteAir(Integer valueOf) {
		// TODO Auto-generated method stub
		airInfoMapper.deleteByShopId(valueOf);
		return null;
	}


}