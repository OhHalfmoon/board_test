package com.ohalfmoon.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;

import com.ohalfmoon.domain.BoardVO;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno > 0") => Mapper.xml에서 대신 처리
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	
}
