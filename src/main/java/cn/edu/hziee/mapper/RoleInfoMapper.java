package cn.edu.hziee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.hziee.model.RoleInfo;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);	@Select("SELECT roleInfo.role_account, roleInfo.role_name as roleName, roleInfo.role_password as rolePassword, roleInfo.role_id as roleId FROM role_info AS roleInfo WHERE roleInfo.role_account = #{account} AND roleInfo.role_password = #{password} ")
	RoleInfo roleLogin(@Param("account")String account,@Param("password")String password);

}