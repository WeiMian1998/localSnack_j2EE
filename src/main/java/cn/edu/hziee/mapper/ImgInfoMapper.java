package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.ImgInfo;

public interface ImgInfoMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(ImgInfo record);

    int insertSelective(ImgInfo record);

    ImgInfo selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(ImgInfo record);

    int updateByPrimaryKey(ImgInfo record);
	@Select("SELECT ImgInfo.review_img, ImgInfo.img_id, ImgInfo.review_id, ImgInfo.shop_id FROM img_info AS ImgInfo WHERE ImgInfo.shop_id = #{shopId} AND ImgInfo.review_id = #{reviewId} ")
	List<HashMap<String,String>> showImg(@Param("shopId")Integer shopId,@Param("reviewId")Integer reviewId);

	@Select("SELECT ImgInfo.img_id, ImgInfo.review_id, ImgInfo.review_img, ImgInfo.shop_id FROM img_info AS ImgInfo WHERE ImgInfo.review_id =  #{reviewId} ")
	List<HashMap<String,String>> findByReviewId(@Param("reviewId")Integer reviewId);

}