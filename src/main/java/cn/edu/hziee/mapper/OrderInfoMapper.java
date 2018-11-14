package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.OrderInfo;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

	void changeState(OrderInfo oi);



	@Select("SELECT orderInfo.shop_id, orderInfo.order_num, orderInfo.order_time, orderInfo.order_type, orderInfo.order_details, orderInfo.send_time, orderInfo.replay_time, orderInfo.fail_massage, orderInfo.order_state, orderInfo.user_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.area_id, shopInfo.office_hours, dictionarydata.`name`, orderInfo.order_id FROM order_info AS orderInfo INNER JOIN user_info AS userInfo ON userInfo.user_id = orderInfo.user_id INNER JOIN shop_info AS shopInfo ON orderInfo.shop_id = shopInfo.shop_id INNER JOIN dictionarydata AS dictionarydata ON orderInfo.order_type = dictionarydata.id WHERE userInfo.token =  #{token}; ")
	List<HashMap<String,String>> showOrder(@Param("token")String token);


	@Select("SELECT orderInfo.order_id, orderInfo.user_id, orderInfo.order_num, orderInfo.order_time, orderInfo.order_type, orderInfo.order_details, orderInfo.send_time, orderInfo.replay_time, orderInfo.fail_massage, orderInfo.order_state, userInfo.user_id, userInfo.user_name, userInfo.telphone, dictionarydata.`name`, userInfo.real_name, userInfo.address FROM order_info AS orderInfo INNER JOIN shop_info AS shopInfo ON shopInfo.shop_id = orderInfo.shop_id INNER JOIN dictionarydata AS dictionarydata ON orderInfo.order_type = dictionarydata.id INNER JOIN user_info AS userInfo ON orderInfo.user_id = userInfo.user_id WHERE shopInfo.shop_id = #{shopId} and orderInfo.order_state < 4; ")
	List<HashMap<String,String>> showShopOrder(@Param("shopId")String shopId);

}