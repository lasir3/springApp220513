package com.choong.spr.mapper;

import java.util.List;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.domain.ReplyDto;

public interface ReplyMapper {

    int insertReply(ReplyDto reply);

	int updateReply(ReplyDto reply);

	List<ReplyDto> replyListByBoardId(int id);

	int deleteReply(ReplyDto reply);

	void deleteReplyByBoard(int id);

}
