package com.choong.spr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.choong.spr.domain.BoardDto;

public interface BoardMapper {

	List<BoardDto> selectBoard(@Param("from") int from, @Param("rowPerPage") int rowPerPage);
	
	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int deleteBoard(int id);

	int insertBoard(BoardDto board);

	List<BoardDto> selectSearchBoard(@Param("search") String search, @Param("from") int from, @Param("rowPerPage") int rowPerPage);

	int selectPageInfo();

	int selectSearchPageInfo(String search);

}
