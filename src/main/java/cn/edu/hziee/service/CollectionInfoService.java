package cn.edu.hziee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hziee.mapper.CollectionInfoMapper;
import cn.edu.hziee.model.CollectionInfo;

@Service
@Transactional
public class CollectionInfoService {
	@Autowired
	CollectionInfoMapper mapper;
	
	public CollectionInfo addCollection(int shopId, int userId) {
		// TODO Auto-generated method stub
		CollectionInfo ci = new CollectionInfo();
		ci.setColState(1);
		ci.setShopId(shopId);
		String coldate = System.currentTimeMillis()+"";
		ci.setColDate(coldate);
		ci.setUserId(userId);
		mapper.insert(ci);
		return ci;
	}



	public List<?> showCollection(int userId) {
		return mapper.showCollection(userId);
	}



	public String deleteCol(int colId) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(colId);
		return "delete success";
	}
	public List<?> showColState(int userId,int shopId) {
		return mapper.showColState(userId,shopId);
	}


	public List<?> showCollectionList(int userId) {
		return mapper.showCollectionList(userId);
	}

}