package cn.edu.hziee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hziee.mapper.ReplayInfoMapper;
import cn.edu.hziee.model.ReplayInfo;


@Service
@Transactional
public class ReplayInfoService {
	@Autowired
	private ReplayInfoMapper mapper;

	public ReplayInfo addReplay(int userId, String pid, String content, String toUserId) {
		// TODO Auto-generated method stub
		ReplayInfo rp = new ReplayInfo();
		rp.setPicId(Integer.valueOf(pid));
		rp.setReplayContent(content);
		rp.setReplayState("2");
		rp.setToUserId(Integer.valueOf(toUserId));
		rp.setUserId(userId);
		String reviewTime = System.currentTimeMillis()+"";
		rp.setReplayTime(reviewTime);
		
		mapper.insert(rp);
		return rp;
	}
	public List<?> replayList(Integer reviewId) {
		return mapper.replayList(reviewId);
	}

	public ReplayInfo addReplayAgain(int userId, String pid, String content, String toUserId) {
		// TODO Auto-generated method stub
		ReplayInfo rp = new ReplayInfo();
		rp.setPicId(Integer.valueOf(pid));
		rp.setReplayContent(content);
		rp.setReplayState("1");
		rp.setToUserId(Integer.valueOf(toUserId));
		rp.setUserId(userId);
		String reviewTime = System.currentTimeMillis()+"";
		rp.setReplayTime(reviewTime);
		
		mapper.insert(rp);
		return rp;
	}

}