package com.ohalfmoon.service;

import java.util.List;

import com.ohalfmoon.domain.Criteria;
import com.ohalfmoon.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);

}
