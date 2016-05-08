package com.nchu.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.nchu.model.TbTask;

@Service
public class TaskService extends BaseService<TbTask>{

	@Override
	public List<TbTask> loadAll(TbTask entity) {
		return super.loadAll(entity);
	}
	@Override
	public void delete(TbTask entity) {
		
		super.delete(entity);
	}
	@Override
	public TbTask getOne(Class clazz, Integer pk) {
		
		return super.getOne(clazz, pk);
	}
	@Override
	public void update(TbTask entity) {
		
		super.update(entity);
	}
	@Override
	public void save(TbTask entity) {
		
		super.save(entity);
	}
	
	public List<TbTask> getAll(Integer publisher){
		
		return dao.getEntitiestNotLazy(new TbTask(), new String[]{"owner"},new Criterion[]{Restrictions.eq("publisher", publisher)});
	}
}
