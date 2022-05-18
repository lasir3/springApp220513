package com.choong.spr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.mapper.BoardMapper;
import com.choong.spr.mapper.ReplyMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private ReplyMapper replyMapper;

	public List<BoardDto> listBoard() {
		return mapper.selectBoard();
	}
	
	public List<BoardDto> searchBoard(String str) {
		String search = "%" + str + "%";
		return mapper.selectSearchBoard(search);
	}

	public BoardDto getBoard(int id) {
		return mapper.getBoard(id);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);
		return cnt == 1; 
	}

	@Transactional // 한번에 처리해야되는 항목 (Transaction)
	public boolean removeBoard(int id) {
		
		replyMapper.deleteReplyByBoard(id);
		
		int cnt = mapper.deleteBoard(id);
		return cnt == 1;
	}

	public boolean addBoard(BoardDto board) {
		board.setInserted(LocalDateTime.now());
		
		int cnt = mapper.insertBoard(board);
		
		return cnt == 1;
	}

}
