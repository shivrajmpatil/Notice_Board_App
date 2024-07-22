package org.CrudDemo.CurdDemo.service;

import org.CrudDemo.CurdDemo.model.NoticeModel;
import org.CrudDemo.CurdDemo.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service("noticeService")
public class NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	public boolean isAddNotice(final NoticeModel model) {
		return noticeRepository.isAddNotice(model);
	}
	
	public List<NoticeModel> getAllNotices(){
		return noticeRepository.getAllNotices();
	}
	
	public boolean deleteNotice(int id)
	{
		return noticeRepository.deleteNotice(id);
	}
}
