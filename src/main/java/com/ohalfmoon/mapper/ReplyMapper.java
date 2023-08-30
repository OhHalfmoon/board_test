package com.ohalfmoon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ohalfmoon.domain.Criteria;
import com.ohalfmoon.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo); // 댓글 작성
	
	public ReplyVO read(Long rno); // 특정 댓글 조회
	
	public int delete (Long rno); // 댓글 삭제
	
	public int update(ReplyVO reply); // 댓글 수정
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno); //페이징이 추가된 댓글 목록
}
