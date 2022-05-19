package com.choong.spr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.ReplyService;

@Controller
@RequestMapping("boardApp")
public class ReplyController {
    
    @Autowired
    private ReplyService service;

    @PostMapping("reply/add")
    public String addReply(ReplyDto reply) {
        boolean success = service.addReply(reply);

        if (success) {
            System.out.println("댓글 작성 성공!!");
        } else {
            System.out.println("댓글 작성 실패...");
        }

        return "redirect:/boardApp/board/" + reply.getBoardId();
    }
    
    @PostMapping("reply/modify")
    public String modifyReply(ReplyDto reply, RedirectAttributes rttr) {
    	boolean successReply = service.modifyReply(reply);
    	
    	if (successReply) {
			rttr.addAttribute("successReply", true);
    		System.out.println("댓글 수정 성공!!");
    	} else {
			rttr.addAttribute("successReply", true);
    		System.out.println("댓글 수정 실패...");
    	}
    	
    	return "redirect:/boardApp/board/" + reply.getBoardId();
    }
    
    @PostMapping("reply/remove")
    public String removeReply(ReplyDto reply) {
    	boolean success = service.removeReply(reply);
    	
    	if (success) {
    		System.out.println("댓글 삭제 성공!!");
    	} else {
    		System.out.println("댓글 삭제 실패...");
    	}
    	
    	return "redirect:/boardApp/board/" + reply.getBoardId();
    }
}
