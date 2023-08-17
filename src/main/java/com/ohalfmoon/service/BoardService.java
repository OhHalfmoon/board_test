package com.ohalfmoon.service;

import java.util.List;

import com.ohalfmoon.domain.BoardVO;

public interface BoardService {
	
	//단일조회
	public BoardVO get(Long bno);
	
	//리스트 조회
	public List<BoardVO> getList();
	
	// 등록
	public void register(BoardVO vo);
	
	//수정
	public boolean modify(BoardVO vo);
	
	//삭제
	public boolean remove(Long bno);
	
	

}
