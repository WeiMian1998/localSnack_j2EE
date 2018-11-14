package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.ReplayInfo;

public interface ReplayInfoMapper {
    int deleteByPrimaryKey(Integer replayId);

    int insert(ReplayInfo record);

    int insertSelective(ReplayInfo record);

    ReplayInfo selectByPrimaryKey(Integer replayId);

    int updateByPrimaryKeySelective(ReplayInfo record);

    int updateByPrimaryKey(ReplayInfo record);
	@Select("SELECT userInfoF.user_id, userInfoF.account, userInfoF.`password`, userInfoF.user_name, userInfoF.token, userInfoF.token_time, userInfoF.telphone, userInfoF.sex, userInfoF.head, userInfoF.address, userInfoF.real_name, userInfoF.introduce, userInfoF.is_shopping, userInfoS.user_name AS toUserName, replayInfo.replay_state, replayInfo.replay_time, replayInfo.replay_content, replayInfo.replay_id, replayInfo.user_id, replayInfo.to_user_id, replayInfo.pic_id FROM replay_info AS replayInfo INNER JOIN review_info AS reviewInfo ON reviewInfo.review_id = replayInfo.pic_id INNER JOIN user_info AS userInfoF ON replayInfo.user_id = userInfoF.user_id INNER JOIN user_info AS userInfoS ON replayInfo.to_user_id = userInfoS.user_id WHERE reviewInfo.review_id = #{reviewId}; ")
	List<HashMap<String,String>> replayList(@Param("reviewId")Integer reviewId);

}