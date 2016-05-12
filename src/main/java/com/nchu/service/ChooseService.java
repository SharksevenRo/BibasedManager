package com.nchu.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.nchu.model.TbChoose;

@Service
public class ChooseService extends BaseService<TbChoose>{
	

	public List<TbChoose> getAll(TbChoose choose){
		Criterion [] criterions = null;
		if(choose.getStudentId()!=null){
			criterions=new Criterion[]{Restrictions.eq("studentId", choose.getStudentId())};
		}
		return dao.getEntitiestNotLazy(new TbChoose(), new String[]{"task"},criterions);
	}
} 
