package com.ohalfmoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohalfmoon.domain.BoardAttachVO;
import com.ohalfmoon.domain.BoardVO;
import com.ohalfmoon.domain.Criteria;
import com.ohalfmoon.mapper.BoardAttachMapper;
import com.ohalfmoon.mapper.BoardMapper;
import com.ohalfmoon.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;

	@Setter(onMethod_= @Autowired)
	private ReplyMapper replyMapper;

	@Setter(onMethod_= @Autowired)
	private BoardAttachMapper attachMapper;

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
	
	@Transactional
	@Override
	public void register(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("register......" + vo);
		mapper.insertSelectKey(vo);
		if(vo.getAttachList() == null || vo.getAttachList().size() <= 0) {
			return;
		}
		vo.getAttachList().forEach(attach ->{
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public boolean modify(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("modify......" + vo);		
		return mapper.update(vo) == 1;
	}
	
	@Transactional
	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove......" + bno);
		if (replyMapper.getCountByBno(bno) > 0) {
			replyMapper.deleteByBno(bno);
		}
		attachMapper.deleteAll(bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		// TODO Auto-generated method stub
		log.info("get Attach list by bno" + bno);
		return attachMapper.findByBno(bno);
	}

	
}
