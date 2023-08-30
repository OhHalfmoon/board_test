package com.ohalfmoon.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ohalfmoon.domain.Criteria;
import com.ohalfmoon.domain.ReplyVO;
import com.ohalfmoon.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
@AllArgsConstructor //spring 4.3의 생성자와 자동주입
public class ReplyServiceImpl implements ReplyService{
	
//	@Setter(onMethod_ = @Autowired)  // AllArgsConstructor를 사용하지 않을 경우 
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("reply Register......" + vo);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		log.info("reply Get......" + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("reply Modify......" + vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		log.info("reply Remove......" + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		log.info("Reply GetList......" + bno);
		return mapper.getListWithPaging(cri, bno);
	}
	
	

}
