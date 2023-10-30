package com.ohalfmoon.mapper;

import java.util.List;

import com.ohalfmoon.domain.BoardAttachVO;

public interface BoardAttachMapper {
	
	public void insert(BoardAttachVO vo);
	public void delete(String uuid);
	public List<BoardAttachVO> findByBno(Long bno);
	public void deleteAll(Long bno);
	
	//전날에 등록된 모든 파일의 목록 확인
	public List<BoardAttachVO> getOldFiles();
	

}
