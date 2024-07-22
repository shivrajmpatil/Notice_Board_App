package org.CrudDemo.CurdDemo.controller;

import java.io.IOException;

import org.CrudDemo.CurdDemo.model.NoticeModel;
import org.CrudDemo.CurdDemo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@RestController
public class HomeController {

	@Autowired
	NoticeService noticeService;
	
	boolean b;
	@GetMapping("/welcome")
	public String getWelcome()
	{
		return "Hey welcome in Rest API";
	}
	
	@PostMapping(value="/saveNotice")
	public String saveNotice(@RequestBody NoticeModel model)
	{
		System.out.println("type ="+model.getType());
		 b= noticeService.isAddNotice(model);
		if(b) {
			return "Notice Added Sucessfully.";
		}
		else
		return "Some Problem is there...";
	}
	
	@GetMapping("/viewAllNotice")
	public List<NoticeModel> getAllNotices(){
		return this.noticeService.getAllNotices();
	}
	
	@DeleteMapping("/deleteNotice/{noticeId}")
	public String deleteNotice(@PathVariable("noticeId")Integer noticeId)
	{
		b= noticeService.deleteNotice(noticeId);
		if(b)
			return "Notice deleted Sucessfully";
		else
			return "Some problem is there";
	}
}
