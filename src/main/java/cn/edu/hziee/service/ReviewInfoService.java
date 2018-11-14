package cn.edu.hziee.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.hziee.mapper.ReviewInfoMapper;
import cn.edu.hziee.model.ReviewInfo;
import cn.edu.hziee.model.ShopInfo;
import cn.edu.hziee.model.UserInfo;
@Service
@Transactional
public class ReviewInfoService{

	@Autowired
	private ReviewInfoMapper mapper;

	public ReviewInfo findById(Integer id) {

		return mapper.selectByPrimaryKey(id);

	}

	public Integer deleteById(Integer id) {

		return mapper.deleteByPrimaryKey(id);

	}

	public Integer update(ReviewInfo entity) {

		return mapper.updateByPrimaryKey(entity);

	}


	public ReviewInfo addReview(int userId, String shopId, String reviewContent, double taste, double environment,
			double service, double reviewScore) {
		// TODO Auto-generated method stub
		String reviewTime = System.currentTimeMillis()+"";
		
		ReviewInfo ri = new ReviewInfo();
		ri.setEnvironment(environment);
		ri.setReviewContent(reviewContent);
		ri.setReviewScore(reviewScore);
		ri.setUserId(userId);
		ri.setTaste(taste);
		ri.setReviewState(1);
		ri.setPeopleAvg(0.0);
		ri.setShopId(Integer.valueOf(shopId));
		ri.setReviewTime(reviewTime);
		ri.setService(service);
		
		mapper.insert(ri);
		
		return ri;
	}
	



	public List<?> ReviewList(Integer shopId) {
		return mapper.ReviewList(shopId);
	}



	public List<?> showReviewList(int userId) {
		return mapper.showReviewList(userId);
	}

	public List<?> showNewReview() {
		List<HashMap<String, String>> demo = mapper.showNewReview();
		for(int i = 0;i<demo.size();i++){
			HashMap map = demo.get(i);
			String content = map.get("review_content").toString();
			if(content.length() >= 30){
				content = content.substring(0, 29);
				map.put("review_content", content);
			}
			demo.set(i, map);
		}
		return demo;
	}

	public ReviewInfo updateReview(int reviewId, String reviewContent, double taste, double environment, double avg,
			double service, double reviewScore) {
		// TODO Auto-generated method stub
		
		String reviewTime = System.currentTimeMillis()+"";
		
		ReviewInfo ri = new ReviewInfo();
		ri.setEnvironment(environment);
		ri.setReviewContent(reviewContent);
		ri.setReviewScore(reviewScore);
		ri.setReviewId(reviewId);
		ri.setTaste(taste);
		ri.setPeopleAvg(avg);
		ri.setReviewTime(reviewTime);
		ri.setService(service);	
		
		mapper.updateByPrimaryKeySelective(ri);
		
		return null;
	}

	public String deleteReview(int reviewId) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(reviewId);
		return "delete success";
	}

	public List<?> findMyReview(Integer userId,Integer shopId) {
		return mapper.findMyReview(userId,shopId);
	}

	public List<?> findReviewByUserId(int userId) {
		return mapper.findReviewByUserId(userId);
	}
	public List<?> showUserReview(int userId) {
		return mapper.showUserReview(userId);
	}

}