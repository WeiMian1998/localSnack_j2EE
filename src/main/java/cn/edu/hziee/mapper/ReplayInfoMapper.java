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

	List<HashMap<String,String>> replayList(@Param("reviewId")Integer reviewId);

}