package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	UserInfo findByToken(String token);

	UserInfo findByAccount(String account);

	void updateByToken(UserInfo u);

	UserInfo login(@Param("account")String account, @Param("password")String password);

	/*void updateByHead(UserInfo u);*/



	@Select("SELECT userInfo.user_id, userInfo.account, userInfo.user_name, userInfo.telphone, userInfo.sex, userInfo.address, userInfo.real_name, userInfo.`password`, userInfo.token, userInfo.token_time, userInfo.head, userInfo.introduce, userInfo.is_shopping FROM user_info AS userInfo LIMIT #{first}, #{each}; ")
	List<HashMap<String,String>> showUser(@Param("first")Integer first,@Param("each")Integer each);

	@Select("SELECT userInfo.user_id, userInfo.account, userInfo.user_name, userInfo.telphone, userInfo.sex, userInfo.address, userInfo.real_name, userInfo.`password`, userInfo.token, userInfo.token_time, userInfo.head, userInfo.introduce, userInfo.is_shopping FROM user_info AS userInfo ")
	List<HashMap<String,String>> showtotal();
	@Select("SELECT userInfo.user_id, userInfo.account, userInfo.`password`, userInfo.user_name, userInfo.token, userInfo.token_time, userInfo.telphone, userInfo.sex, userInfo.head, userInfo.address, userInfo.real_name, userInfo.introduce, userInfo.is_shopping FROM user_info AS userInfo WHERE userInfo.user_id = #{userId} ")
	List<HashMap<String,String>> findByUserId(@Param("userId")Integer userId);

}