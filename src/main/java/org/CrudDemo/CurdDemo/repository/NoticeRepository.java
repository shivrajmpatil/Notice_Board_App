package org.CrudDemo.CurdDemo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.CrudDemo.CurdDemo.model.NoticeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("noticeRepository")
public class NoticeRepository {

	@Autowired
	JdbcTemplate template;
	int value=0;
	private int getNoticeId() {
		List<Integer> list= template.query("select max(id) from noticetype", (ResultSet rs, int rowNum) ->  rs.getInt(1));
		if(list.size()>0) {
		 value= list.get(0);
			++value;
			return value;
		}
		else
		{
			++value;
			return value;
		}
		
	}
	
	public boolean isAddNotice(final NoticeModel model)
	{
		final int noticeId= this.getNoticeId();
		value= template.update("insert into noticetype values(?,?)", (PreparedStatement ps) -> {
				ps.setInt(1, noticeId);
				ps.setString(2, model.getType());
		});
		return true;
	}
	
	public List<NoticeModel> getAllNotices(){
		List<NoticeModel> list= template.query("select *from noticetype order by id", new RowMapper<NoticeModel>() {

			@Override
			public NoticeModel mapRow(ResultSet rs, int rowNum) throws SQLException {

				NoticeModel model = new NoticeModel();
				model.setId(rs.getInt(1));
				model.setType(rs.getString(2));
				return model;
			}
			
		});
		return list;
	}
	
	
	public boolean deleteNotice(int id)
	{
		value = template.update("delete from noticetype where id="+id);
		
		return value>0?true:false;
	}
}
