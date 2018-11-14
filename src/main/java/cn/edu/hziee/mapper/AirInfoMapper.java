package cn.edu.hziee.mapper;

import cn.edu.hziee.model.AirInfo;

public interface AirInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AirInfo record);

    int insertSelective(AirInfo record);

    AirInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AirInfo record);

    int updateByPrimaryKey(AirInfo record);

	void deleteByShopId(Integer valueOf);
	



}