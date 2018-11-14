package cn.edu.hziee.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hziee.mapper.ShopInfoMapper;
import cn.edu.hziee.model.ShopInfo;

@Service
@Transactional
public class ShopInfoService {
	@Autowired
	private ShopInfoMapper shopInfoMapper;

	public ShopInfo addShop(String shopName, String shopAddress, String shopTelphone, String officeHours, int userId,
			String content, int areaId) {
		// TODO Auto-generated method stub
		ShopInfo shop = new ShopInfo();
		shop.setAreaId(areaId);
		shop.setContent(content);
		shop.setOfficeHours(officeHours);
		shop.setShopAddress(shopAddress);
		shop.setShopName(shopName);
		shop.setShopTelphone(shopTelphone);
		shop.setUserId(userId);
		
		shopInfoMapper.insert(shop);
		return shop;
	}

/*	public List<ShopInfo> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		
		return shopInfoMapper.findByUserId(userId);
	}*/
	public List<?> showMyShop(String token) {
		return shopInfoMapper.showMyShop(token);
	}

	public List<?> showArea(Integer shopId) {
		return shopInfoMapper.showArea(shopId);
	}

	public List<?> showAir(Integer shopId) {
		return shopInfoMapper.showAir(shopId);
	}


	public List<?> showCuisine(Integer shopId) {
		return shopInfoMapper.showCuisine(shopId);
	}

	public ShopInfo updateShop(String shopId, String shopName, String shopAddress, String shopTelphone,
			String officeHours, String content, int areaId) {
		// TODO Auto-generated method stub
		ShopInfo s = new ShopInfo();
		s.setAreaId(areaId);
		s.setContent(content);
		s.setShopTelphone(shopTelphone);
		s.setShopName(shopName);
		s.setShopAddress(shopAddress);
		s.setOfficeHours(officeHours);
		s.setShopId(Integer.valueOf(shopId));
		
		shopInfoMapper.updateByShopId(s);
		return null;
	}

	public ShopInfo updateImg(String shopId, String shopImg) {
		// TODO Auto-generated method stub
		ShopInfo s = new ShopInfo();
		
		s.setShopId(Integer.valueOf(shopId));
		s.setShopImage(shopImg);
		
		shopInfoMapper.updateByImg(s);
		return null;
	}

	public List<?> findByShopId(Integer shopId) {
		return shopInfoMapper.findByShopId(shopId);
	}

	public List<?> findByShopName(String keyword) {
		return shopInfoMapper.findByShopName("%"+keyword+"%");
	}

	public List<?> findByAreaId(Integer areaId) {
		return shopInfoMapper.findByAreaId(areaId);
	}

	public List<?> findByAirId(Integer airId) {
		return shopInfoMapper.findByAirId(airId);
	}

	public List<?> findByCuisineId(Integer cuisineId) {
		return shopInfoMapper.findByCuisineId(cuisineId);
	}

	public List<?> showScore(Integer shopId) {
		return shopInfoMapper.showScore(shopId);
	}

	public List<?> showHotShop() {
		return shopInfoMapper.showHotShop();
	}

	public List<?> showHotByCuisine(Integer cuisineId) {
		List<HashMap<String, String>> demo = shopInfoMapper.showHotByCuisine(cuisineId);
		for(int i = 0;i<demo.size();i++){
			HashMap map = demo.get(i);
			String content = map.get("shop_name").toString();
			if(content.length() >= 12){
				content = content.substring(0, 11);
				map.put("shop_name", content);
			}
			demo.set(i, map);
		}
		return demo;
	}

}