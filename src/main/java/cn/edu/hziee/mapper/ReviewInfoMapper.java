package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.ReviewInfo;

public interface ReviewInfoMapper {
    int deleteByPrimaryKey(Integer reviewId);

    int insert(ReviewInfo record);

    int insertSelective(ReviewInfo record);

    ReviewInfo selectByPrimaryKey(Integer reviewId);

    int updateByPrimaryKeySelective(ReviewInfo record);

    int updateByPrimaryKey(ReviewInfo record);
	@Select("SELECT userInfo.account, userInfo.`password`, userInfo.user_name, userInfo.token, userInfo.token_time, userInfo.telphone, userInfo.sex, userInfo.head, userInfo.address, userInfo.real_name, userInfo.introduce, userInfo.is_shopping, reviewInfo.review_id, reviewInfo.user_id, reviewInfo.shop_id, reviewInfo.review_content, reviewInfo.review_time, reviewInfo.taste, reviewInfo.environment, reviewInfo.service, reviewInfo.review_score, reviewInfo.review_state, reviewInfo.good, reviewInfo.replay, reviewInfo.people_avg, shopInfo.shop_name FROM review_info AS reviewInfo INNER JOIN user_info AS userInfo ON reviewInfo.user_id = userInfo.user_id INNER JOIN shop_info AS shopInfo ON reviewInfo.shop_id = shopInfo.shop_id WHERE reviewInfo.shop_id = #{shopId}; ")
	List<HashMap<String,String>> ReviewList(@Param("shopId")Integer shopId);

	@Select("SELECT reviewInfo.review_id, reviewInfo.shop_id, reviewInfo.review_content, reviewInfo.review_time, reviewInfo.taste, reviewInfo.environment, reviewInfo.service, reviewInfo.people_avg, reviewInfo.user_id, reviewInfo.review_score, reviewInfo.review_state, shopInfo.shop_name, shopInfo.area_id, shopInfo.shop_telphone, shopInfo.shop_address, shopInfo.content, shopInfo.shop_image, shopInfo.office_hours, userInfo.user_name, userInfo.telphone, userInfo.head, userInfo.address, userInfo.real_name, userInfo.introduce, userInfo.is_shopping FROM review_info AS reviewInfo INNER JOIN shop_info AS shopInfo ON reviewInfo.shop_id = shopInfo.shop_id INNER JOIN user_info AS userInfo ON reviewInfo.user_id = userInfo.user_id WHERE reviewInfo.user_id =  #{userId} AND reviewInfo.review_state = 1; ")
	List<HashMap<String,String>> showReviewList(@Param("userId")Integer userId);

	@Select("SELECT reviewInfo.review_id, reviewInfo.user_id, reviewInfo.shop_id, reviewInfo.review_content, reviewInfo.review_time, reviewInfo.taste, reviewInfo.environment, reviewInfo.service, reviewInfo.review_score, reviewInfo.review_state, reviewInfo.good, reviewInfo.replay, reviewInfo.people_avg, shopInfo.shop_telphone, shopInfo.shop_address, shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.office_hours, shopInfo.shop_image,userInfo.user_name,dictionaryData.`name` FROM review_info AS reviewInfo INNER JOIN shop_info AS shopInfo ON reviewInfo.shop_id = shopInfo.shop_id INNER JOIN user_info AS userInfo ON reviewInfo.user_id = userInfo.user_id INNER JOIN dictionarydata AS dictionaryData ON shopInfo.area_id = dictionaryData.id ORDER BY reviewInfo.review_id DESC LIMIT 0, 4 ")
	List<HashMap<String,String>> showNewReview();

	@Select("SELECT reviewInfo.review_id, reviewInfo.user_id, reviewInfo.shop_id, reviewInfo.review_content, reviewInfo.review_time, reviewInfo.taste, reviewInfo.environment, reviewInfo.service, reviewInfo.review_score, reviewInfo.review_state, reviewInfo.people_avg FROM review_info AS reviewInfo WHERE reviewInfo.user_id = #{userId} AND reviewInfo.shop_id = #{shopId}  ")
	List<HashMap<String,String>> findMyReview(@Param("userId")Integer userId,@Param("shopId")Integer shopId);

	void updateByMy(ReviewInfo ri);

	@Select("SELECT reviewInfo.review_id, reviewInfo.user_id, reviewInfo.shop_id, reviewInfo.review_content, reviewInfo.review_time, reviewInfo.taste, reviewInfo.environment, reviewInfo.service, reviewInfo.review_score, reviewInfo.review_state, reviewInfo.people_avg, userInfo.user_name, userInfo.head FROM review_info AS reviewInfo INNER JOIN user_info AS userInfo ON reviewInfo.user_id = userInfo.user_id WHERE reviewInfo.user_id=  #{userId} ")
	List<HashMap<String,String>> findReviewByUserId(@Param("userId")Integer userId);
	@Select("SELECT reviewInfo.review_id, reviewInfo.user_id, reviewInfo.shop_id, reviewInfo.review_content, reviewInfo.people_avg, reviewInfo.review_state, reviewInfo.review_score, reviewInfo.service, reviewInfo.environment, reviewInfo.taste, reviewInfo.review_time, shopInfo.shop_name, shopInfo.shop_address, shopInfo.shop_telphone FROM review_info AS reviewInfo INNER JOIN shop_info AS shopInfo ON reviewInfo.shop_id = shopInfo.shop_id WHERE reviewInfo.user_id =  #{userId} ")
	List<HashMap<String,String>> showUserReview(@Param("userId")Integer userId);

}