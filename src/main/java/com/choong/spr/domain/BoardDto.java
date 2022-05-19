package com.choong.spr.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	
	private int id;
	private String title;
	private String body;
	private LocalDateTime inserted;
	private int views;
//	
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		if(title.length() > 10) {
//		}
//		this.title = title;
//	}

	// 댓글의 갯수
	private int numOfReply;
	
	public String getPrettyInserted() {
		// 24시간 이내면 시간만
		// 이전이면 년-월-일
		LocalDateTime now = LocalDateTime.now();
		if (now.minusHours(24).isBefore(inserted)) {
			return inserted.toLocalTime().toString();
		} else {
			return inserted.toLocalDate().toString();
		}
	}
}
