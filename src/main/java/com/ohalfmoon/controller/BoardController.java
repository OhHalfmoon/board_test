package com.ohalfmoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohalfmoon.domain.BoardVO;
import com.ohalfmoon.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService boardService;
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		model.addAttribute("board", boardService.get(bno));
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", boardService.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register: " + vo);
		boardService.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("modify: "+ vo);
		if(boardService.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("removr: " + bno);
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "succeess");
		}
		return "redirect:/board/list";
	}

}