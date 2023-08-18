package com.ohalfmoon.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ohalfmoon.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testGet() {
		log.info(service.get(56L));
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
			
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("서비스작성글");
		vo.setContent("서비스 작성 테스트");
		vo.setWriter("test00");
		
		service.register(vo);
		
		log.info("생성된 게시물의 번호: " + vo.getBno());
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = service.get(57L);
		
		if (vo == null) {
			return;
		}
		
		vo.setTitle("제목수정");
		vo.setContent("내용수정");
		vo.setWriter("작성자변경");
		log.info("MODIFY RESULT: " + service.modify(vo));
	}
	
	@Test
	public void testDelete() {
		log.info("REMOVE RESULT: " + service.remove(62L));
	}

}
