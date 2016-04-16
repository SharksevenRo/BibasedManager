package com.nchu.service;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nchu.hibnernate.support.FieldType;
import com.nchu.hibnernate.support.HibernateSupportDao;
import com.nchu.hibnernate.support.Page;
import com.nchu.util.ReflectionUtils;

@Service
public class BaseService<T>{

	@Autowired
	@Qualifier(value="hibernateSupportDao")
	
	private HibernateSupportDao<T, ?> dao;

	public void Delete(T entity) {
		dao.delete(entity);
	}

	public void update(T entity) {
		dao.saveOrUpdate(entity);
	}

	public void save(T entity) {
		dao.save(entity);
	}
	public List<T> loadAll(T entity) {
		String name = entity.getClass().getSimpleName();
		StringBuilder hql=new StringBuilder();
		hql.append("from "+name+" where 1=1");
		List<Field> accessibleFields = ReflectionUtils.getAccessibleFields(entity.getClass(), false);
		Object value = null;
		Map<String, Object> map=new HashMap<String, Object>();
		for (Field field : accessibleFields) {
			try {
				
				if(isBase(field.getType())){
					value= ReflectionUtils.invokeGetterMethod(entity, field.getName());
					
					if(value!=null){
						map.put(field.getName(), value);
						hql.append(" and "+field.getName()+"=:"+field.getName());
					}
				}
			} catch (Exception e) {
			}
		}
		
		return dao.createQuery(hql.toString(), map).list();
	}

	@SuppressWarnings("unchecked")
	public Page<T> page(Page<T> page) {
		String name = page.getClass().getSimpleName();
		StringBuilder hql=new StringBuilder();
		hql.append("from "+name+" where deleteFlag=1");
		List<Field> accessibleFields = ReflectionUtils.getAccessibleFields(page.getClass(), true);
		Object value = null;
		Map<String, Object> map=new HashMap<String, Object>();
		for (Field field : accessibleFields) {
			if(isBase(field.getType())){
				value= ReflectionUtils.invokeGetterMethod(page, field.getName());
				
				if(value!=null){
					map.put(field.getName(), value);
					hql.append(" and "+field.getName()+"=:"+field.getName());
				}
			}
		}
		String hql2 = dao.setPageRequestToHql(hql.toString(), page);
		return dao.findPage(page, dao.createQuery(hql2, map));
	}

	public T getOne(Class clazz,String pk) {
		return (T) dao.getSession().load(clazz, pk);
	}
	
	private boolean isBase(Class clazz){
		
		if(clazz.equals(Boolean.class)||clazz.equals(String.class)||clazz.equals(Integer.class)||clazz.equals(Double.class)||clazz.equals(Date.class)|clazz.equals(Long.class)){
			return true;
		}
		return false;
	}
}
