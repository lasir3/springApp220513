package com.choong.spr.domain;

import lombok.Data;

@Data
public class PageInfoDto {
	
	private int current;
	private int end;

	public int getLeft() {
		return Math.max(current - 3, 1);
	}
	public int getRight() {
		return Math.min(current + 3, end);
	}
}


