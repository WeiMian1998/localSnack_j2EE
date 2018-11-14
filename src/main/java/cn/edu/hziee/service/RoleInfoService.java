package cn.edu.hziee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hziee.mapper.RoleInfoMapper;
import cn.edu.hziee.model.RoleInfo;
import cn.edu.hziee.model.UserInfo;

@Service
@Transactional
public class RoleInfoService {
	@Autowired
	RoleInfoMapper mapper;
	public RoleInfo roleLogin(String account, String password) {
		// TODO Auto-generated method stub
		RoleInfo ri = new RoleInfo(); 
		ri = mapper.roleLogin(account, password);
		return ri;
	}

}
