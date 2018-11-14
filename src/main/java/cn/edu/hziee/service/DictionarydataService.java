package cn.edu.hziee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.mapper.DictionarydataMapper;
import cn.edu.hziee.model.Dictionarydata;

@Service
public class DictionarydataService {
	@Autowired
	private DictionarydataMapper mapper;
	
	
	public List<Dictionarydata> findByParentId(Integer parentId) {
		
		return mapper.findByParentId(parentId);
		
		
	}


}