package com.nchu.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.nchu.model.TbChoose;
import com.nchu.model.TbNotice;
import com.nchu.model.TbTask;
import com.nchu.model.TbUser;

@Service
public class UserService extends BaseService<TbUser>{

	public List<TbUser> getAll(TbUser user){
		
		Criterion [] criterions = null;
		if(user.getRoleId()!=null){
			criterions=new Criterion[]{Restrictions.eq("roleId", user.getRoleId())};
			return dao.getEntitiestNotLazy(new TbUser(), null,criterions);
		}
		if(user.getTeacher()!=null){
			
			criterions=new Criterion[]{Restrictions.eq("teacher", user.getTeacher())};
			List<TbUser> users = dao.getEntitiestNotLazy(new TbUser(), null,criterions);
			
			for (TbUser tbUser : users) {
				tbUser.setTasks(getTaks(tbUser));
			}
			return users;
		}
		return null;
	}
	
	public List<TbTask> getTaks(TbUser user){
		Criterion [] criterions = null;
		criterions=new Criterion[]{Restrictions.eq("studentId", user.getId())}; 
		List<TbChoose> chooses = dao.getEntitiestNotLazy(new TbChoose(), new String[]{"task"},criterions);
		
		List<TbTask> tasks=new ArrayList<TbTask>();
		
		for (TbChoose choose : chooses) {
			tasks.add(choose.getTask());
		}
		return tasks;
	} 
}
