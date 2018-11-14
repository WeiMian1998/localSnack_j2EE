package cn.edu.hziee.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hziee.mapper.UserInfoMapper;
import cn.edu.hziee.model.UserInfo;

@Service
@Transactional
public class UserInfoService {
	@Autowired 
	private UserInfoMapper userInfoMapper;

	public UserInfo findUser(String token) {
		// TODO Auto-generated method stub
		UserInfo u = userInfoMapper.findByToken(token);
		
		return u;
	}
	
	public Object register(String account, String password, String userName) {
		// TODO Auto-generated method stub
		UserInfo u = new UserInfo();
		
		u = userInfoMapper.findByAccount(account);
		if(u != null)
			return "account is esist";
		else{
			u = new UserInfo();
			u.setAccount(account);
/*			u.setAddress(null);*/
			u.setPassword(password);
			u.setUserName(userName);
			u.setHead("https://p0.meituan.net/userheadpic/bun.png");/*默认头像*/
/*			u.setIntroduce(null);
			u.setRealName(null);
			u.setSex(null);*/
			u.setToken(getUUid());
/*			u.setTelphone(null);*/
			u.setIsShopping("0");
			u.setTokenTime((System.currentTimeMillis()+3*24*60*60*1000)+"");	
			userInfoMapper.insert(u);
			return u;
		}
	}
	
	
	public static String getUUid(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}

	public UserInfo updateUser(String token, String realName, String userName, String telphone, String sex, String address, String introduce) {
		// TODO Auto-generated method stub
		UserInfo u = new UserInfo();
		
		u.setToken(token);
		u.setIntroduce(introduce);
		u.setRealName(realName);
		u.setSex(sex);
		u.setAddress(address);
		u.setUserName(userName);
		u.setTelphone(telphone);
		
		 userInfoMapper.updateByToken(u);
		return u;
	}

	public UserInfo login(String account, String password) {
		// TODO Auto-generated method stub
		UserInfo u = new UserInfo();
		u = userInfoMapper.login(account,password);
			return u;
	}

	public UserInfo updateHead(String token, String head) {
		// TODO Auto-generated method stub
		UserInfo u = new UserInfo();
		
		u.setHead(head);
		u.setToken(token);
		
		userInfoMapper.updateByToken(u);
		return u;
	}

	public UserInfo shopping(String token, String isShop) {
		// TODO Auto-generated method stub
		UserInfo u = new UserInfo();
		u.setToken(token);
		u.setIsShopping(isShop);
		userInfoMapper.updateByToken(u);
		
		userInfoMapper.findByToken(token);
		return u;
	}


	public List<?> showUser(Integer first,Integer each) {
		System.out.println("first="+first+","+each);
		return userInfoMapper.showUser( (first-1)*each,each);
	}

	public List<?> showtotal() {
		return userInfoMapper.showtotal();
	}

	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		userInfoMapper.deleteByPrimaryKey(userId);
		return "delete success";
	}

	public Object addUser(String account, String password, String userName, String realName, String telphone,
			String address) {
		// TODO Auto-generated method stub
		UserInfo u = new UserInfo();
		
		u.setAccount(account);
		u.setPassword(password);
		u.setRealName(realName);
		u.setAddress(address);
		u.setUserName(userName);
		u.setTelphone(telphone);
		u.setToken(getUUid());
		u.setHead("https://p0.meituan.net/userheadpic/bun.png");/*默认头像*/
		u.setIsShopping("0");
		u.setTokenTime((System.currentTimeMillis()+3*24*60*60*1000)+"");
		
		userInfoMapper.insert(u);
		
		return "添加成功";
	}
	public List<?> findByUserId(int userId) {
		return userInfoMapper.findByUserId(userId);
	}

	public UserInfo updateUserByRole(int userId, String realName, String userName, String telphone, String address,
			String introduce) {
		// TODO Auto-generated method stub
		UserInfo u = new UserInfo();
		
		u.setUserId(userId);
		u.setIntroduce(introduce);
		u.setRealName(realName);
		u.setAddress(address);
		u.setUserName(userName);
		u.setTelphone(telphone);
		
		userInfoMapper.updateByPrimaryKeySelective(u);
		return u;
	}

}