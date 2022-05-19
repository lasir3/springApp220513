package com.choong.spr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choong.spr.domain.ReplyDto;
import com.choong.spr.mapper.ReplyMapper;

@Service
public class ReplyService {

    @Autowired
    private ReplyMapper mapper;

    public boolean addReply(ReplyDto reply) {
//    	reply.setInserted(LocalDateTime.now());
        int cnt = mapper.insertReply(reply);
        return cnt == 1;
    }

	public boolean modifyReply(ReplyDto reply) {
		int cnt = mapper.updateReply(reply);
		return cnt == 1;
	}

	public List<ReplyDto> getReplyListByBoardId(int id) {
		return mapper.replyListByBoardId(id);
	}

	public boolean removeReply(ReplyDto reply) {
		int cnt = mapper.deleteReply(reply);
		return cnt == 1;
	}


}
