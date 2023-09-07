package com.ohalfmoon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohalfmoon.domain.Criteria;
import com.ohalfmoon.domain.ReplyPageDTO;
import com.ohalfmoon.domain.ReplyVO;
import com.ohalfmoon.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies")
@RestController // Controller + ResponseBody, Controller가 REST방식으로 처리
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("Controller_ReplyVO: " + vo);
		int insertCount = service.register(vo);
		log.info("Contoller_Reply INSERT COUNT: " + insertCount);
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
/*	@GetMapping(value = "/pages/{bno}/{page}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {
		log.info("Controller_GetList......");
		Criteria cri = new Criteria(page,10);
		log.info("Contoller_cri");
		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
	}*/
	@GetMapping(value = "/pages/{bno}/{page}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {
		log.info("Controller_GetList......");
		Criteria cri = new Criteria(page,10);
		log.info("Contoller_cri" + cri);
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{rno}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
		log.info("Contoller_Get: " + rno);
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{rno}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		log.info("Controller_Remove: " +rno);
		return service.remove(rno) ==1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/{rno}", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno) {
		vo.setRno(rno);
		log.info("Controller_Rno: " + rno);
		log.info("Controller_Modify: " + vo);
		return service.modify(vo) ==1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
