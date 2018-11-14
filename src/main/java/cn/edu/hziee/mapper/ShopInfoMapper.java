package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.Dictionarydata;
import cn.edu.hziee.model.ShopInfo;

public interface ShopInfoMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    ShopInfo selectByPrimaryKey(Integer shopId);

    int updateByPrimaryKeySelective(ShopInfo record);

    int updateByPrimaryKey(ShopInfo record);

/*	List findByUserId(Integer userId);*/
    
	@Select("SELECT shopInfo.shop_id, shopInfo.user_id, shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.hot, shopInfo.office_hours, shopInfo.air_id, shopInfo.cuisine_id FROM shop_info AS shopInfo INNER JOIN user_info AS userInfo ON userInfo.user_id = shopInfo.user_id WHERE userInfo.token = #{token} ")
	List<HashMap<String,String>> showMyShop(@Param("token")String token);

	@Select("SELECT dictionarydata.`name` FROM shop_info AS shopInfo INNER JOIN dictionarydata ON shopInfo.area_id = dictionarydata.id WHERE dictionarydata.is_show = 1 AND shopInfo.shop_id = #{shopId}; ")
	List<HashMap<String,String>> showArea(@Param("shopId")Integer shopId);

	@Select("SELECT dictionarydata.`name`, air_info.air_id FROM shop_info INNER JOIN air_info ON shop_info.shop_id = air_info.shop_id INNER JOIN dictionarydata ON air_info.air_id = dictionarydata.id WHERE dictionarydata.is_show = 1 AND shop_info.shop_id = #{shopId}; ")
	List<HashMap<String,String>> showAir(@Param("shopId")Integer shopId);


	@Select("SELECT dictionarydata.`name`, cuisine_info.cuisine_id FROM shop_info INNER JOIN cuisine_info ON shop_info.shop_id = cuisine_info.shop_id INNER JOIN dictionarydata ON cuisine_info.cuisine_id = dictionarydata.id WHERE dictionarydata.is_show = 1 AND shop_info.shop_id = #{shopId}; ")
	List<HashMap<String,String>> showCuisine(@Param("shopId")Integer shopId);

	void updateByShopId(ShopInfo s);

	void updateByImg(ShopInfo s);


	@Select("SELECT shopInfo.shop_id, shopInfo.user_id, shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.hot, shopInfo.office_hours, shopInfo.air_id, shopInfo.cuisine_id FROM shop_info AS shopInfo WHERE shopInfo.shop_id = #{shopId}; ")
	List<HashMap<String,String>> findByShopId(@Param("shopId")Integer shopId);

	@Select("SELECT shop_info.user_id, shop_info.area_id, shop_info.shop_name, shop_info.content, shop_info.shop_address, shop_info.shop_telphone, shop_info.shop_image, shop_info.hot, shop_info.office_hours, shop_info.air_id, shop_info.cuisine_id, shop_info.shop_id FROM shop_info WHERE shop_info.shop_name LIKE #{keyword} ")
	List<HashMap<String,String>> findByShopName(@Param("keyword")String keyword);

	@Select("SELECT shopInfo.shop_id, shopInfo.user_id, shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.hot, shopInfo.office_hours, shopInfo.air_id, shopInfo.cuisine_id FROM shop_info AS shopInfo WHERE shopInfo.area_id = #{areaId} ")
	List<HashMap<String,String>> findByAreaId(@Param("areaId")Integer areaId);

	@Select("SELECT shopInfo.shop_id, shopInfo.user_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.office_hours FROM shop_info AS shopInfo INNER JOIN air_info AS airInfo ON airInfo.shop_id = shopInfo.shop_id WHERE airInfo.air_id = #{airId} ")
	List<HashMap<String,String>> findByAirId(@Param("airId")Integer airId);

	@Select("SELECT shopInfo.shop_id, shopInfo.user_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.office_hours FROM shop_info AS shopInfo INNER JOIN cuisine_info ON cuisine_info.shop_id = shopInfo.shop_id WHERE cuisine_info.cuisine_id =  #{cuisineId} ")
	List<HashMap<String,String>> findByCuisineId(@Param("cuisineId")Integer cuisineId);


	@Select("SELECT truncate(Avg(reviewInfo.review_score),1) AS score, truncate(Avg(reviewInfo.taste),1) AS taste, truncate(Avg(reviewInfo.environment),1) AS environment, truncate(Avg(reviewInfo.service),1) AS service, truncate(Avg(reviewInfo.people_avg),0) AS avg FROM shop_info AS shopInfo INNER JOIN review_info AS reviewInfo ON shopInfo.shop_id = reviewInfo.shop_id WHERE shopInfo.shop_id = #{shopId}; ")
	List<HashMap<String,String>> showScore(@Param("shopId")Integer shopId);

	@Select("SELECT shopInfo.shop_id,shopInfo.user_id,shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.hot, shopInfo.office_hours FROM shop_info AS shopInfo ORDER BY CAST(shopInfo.hot as SIGNED INTEGER) DESC LIMIT 0,8 ")
	List<HashMap<String,String>> showHotShop();


	@Select("SELECT shopInfo.shop_id, shopInfo.user_id, shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.hot, shopInfo.office_hours FROM shop_info AS shopInfo INNER JOIN cuisine_info AS cuisineInfo ON cuisineInfo.shop_id = shopInfo.shop_id WHERE cuisineInfo.cuisine_id = #{cuisineId} ORDER BY cast(shopInfo.hot as SIGNED INTEGER) DESC LIMIT 0, 4 ")
	List<HashMap<String,String>> showHotByCuisine(@Param("cuisineId")Integer cuisineId);

}