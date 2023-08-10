package com.ohalfmoon.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
//	@DateTimeFormat(pattern = "yyyy/MM/dd") -> 어노테이션 사용시 controller에서 @InitBinder 필요x
	private Date dueDate;
}
