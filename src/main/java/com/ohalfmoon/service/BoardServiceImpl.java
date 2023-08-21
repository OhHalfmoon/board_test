package com.ohalfmoon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ohalfmoon.domain.BoardVO;
import com.ohalfmoon.domain.Criteria;
import com.ohalfmoon.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get......" + bno);
		return mapper.read(bno);
	}

//	@Override
//	public List<BoardVO> getList() {
//		// TODO Auto-generated method stub
//		log.info("getList......");
//		return mapper.getList();
//	}
	
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get List with criteria" + cri);
		return mapper.getListWithPaging(cri);
	}	
	

	@Override
	public void register(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("register......" + vo);
		mapper.insertSelectKey(vo);
		
	}

	@Override
	public boolean modify(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("modify......" + vo);		
		return mapper.update(vo) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove......" + bno);
		return mapper.delete(bno) == 1;
	}



	
}
