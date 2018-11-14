package cn.edu.hziee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hziee.mapper.ImgInfoMapper;
import cn.edu.hziee.model.ImgInfo;

@Service
@Transactional
public class ImgInfoService {
	@Autowired
	private ImgInfoMapper mapper;
	
	public ImgInfo addImg(int reviewId, String img,int shopId) {
		// TODO Auto-generated method stub
		ImgInfo im = new ImgInfo();
		im.setReviewId(reviewId);
		im.setReviewImg(img);
		im.setShopId(shopId);
		mapper.insert(im);
		return im;
	}

	public ImgInfo updateImg(int imgId, String img) {
		// TODO Auto-generated method stub
		ImgInfo im = new ImgInfo();
		im.setReviewImg(img);
		im.setImgId(imgId);
		mapper.updateByPrimaryKeySelective(im);
		return null;
	}	public List<?> showImg(Integer shopId,Integer reviewId) {
		return mapper.showImg(shopId,reviewId);
	}

}