package cn.edu.hziee.mapper;

import cn.edu.hziee.model.CuisineInfo;

public interface CuisineInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CuisineInfo record);

    int insertSelective(CuisineInfo record);

    CuisineInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CuisineInfo record);

    int updateByPrimaryKey(CuisineInfo record);

	void deleteByShopId(Integer valueOf);
}