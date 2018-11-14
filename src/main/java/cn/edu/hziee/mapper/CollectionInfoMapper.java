package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.CollectionInfo;

public interface CollectionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectionInfo record);

    int insertSelective(CollectionInfo record);

    CollectionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectionInfo record);

    int updateByPrimaryKey(CollectionInfo record);


	@Select("SELECT shopInfo.shop_id, shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, shopInfo.shop_telphone, shopInfo.shop_image, shopInfo.office_hours, collectionInfo.id, collectionInfo.shop_id, collectionInfo.col_date, collectionInfo.col_state, dictionaryData.id, dictionaryData.`name` FROM collection_info AS collectionInfo INNER JOIN user_info AS userInfo ON userInfo.user_id = collectionInfo.user_id INNER JOIN shop_info AS shopInfo ON collectionInfo.shop_id = shopInfo.shop_id INNER JOIN dictionarydata AS dictionaryData ON shopInfo.area_id = dictionaryData.id WHERE userInfo.user_id = #{userId} AND collectionInfo.col_state = 1; ")
	List<HashMap<String,String>> showCollection(@Param("userId")Integer userId);

	@Select("SELECT collectionInfo.col_state,collectionInfo.id,collectionInfo.shop_id,collectionInfo.user_id,collectionInfo.col_date FROM collection_info AS collectionInfo INNER JOIN user_info AS userInfo ON userInfo.user_id = collectionInfo.user_id WHERE userInfo.user_id = #{userId}  AND collectionInfo.shop_id = #{shopId}  ")
	List<HashMap<String,String>> showColState(@Param("userId")Integer userId,@Param("shopId")Integer shopId);

	@Select("SELECT collectionInfo.id, collectionInfo.shop_id, collectionInfo.user_id, collectionInfo.col_date, collectionInfo.col_state, shopInfo.office_hours, shopInfo.area_id, shopInfo.shop_name, shopInfo.content, shopInfo.shop_address, dictionarydata.`name`, userInfo.real_name, userInfo.address, userInfo.telphone, userInfo.user_name, userInfo.user_id, userInfo.account, userInfo.`password`, userInfo.token, userInfo.token_time, userInfo.sex, userInfo.head, userInfo.introduce, userInfo.is_shopping FROM collection_info AS collectionInfo INNER JOIN user_info AS userInfo ON userInfo.user_id = collectionInfo.user_id INNER JOIN shop_info AS shopInfo ON collectionInfo.shop_id = shopInfo.shop_id INNER JOIN dictionarydata AS dictionarydata ON shopInfo.area_id = dictionarydata.id WHERE userInfo.user_id = #{userId} AND collectionInfo.col_state = 1; ")
	List<HashMap<String,String>> showCollectionList(@Param("userId")Integer userId);

}