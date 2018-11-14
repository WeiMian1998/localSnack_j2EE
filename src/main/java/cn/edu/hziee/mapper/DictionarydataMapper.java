package cn.edu.hziee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.Dictionarydata;

public interface DictionarydataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dictionarydata record);

    int insertSelective(Dictionarydata record);

    Dictionarydata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionarydata record);

    int updateByPrimaryKey(Dictionarydata record);
    
    @Select("SELECT " + 
			"dictionarydata.id AS id, " + 
			"dictionarydata.`name` AS `name`, " + 
			"dictionarydata.pid AS pid, " + 
			"dictionarydata.is_show AS isShow, " + 
			"dictionarydata.sort_id AS sortId " + 
			"FROM " + 
			"dictionarydata AS dictionarydata " + 
			"WHERE " + 
			"dictionarydata.pid = #{parentId} " + 
			"ORDER BY " + 
			"sortId ASC " + 
			"")
	List<Dictionarydata> findByParentId(@Param("parentId")Integer parentId);

}