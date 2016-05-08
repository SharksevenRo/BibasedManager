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
import org.springframework.transaction.annotation.Transactional;

import com.nchu.hibnernate.support.FieldType;
import com.nchu.hibnernate.support.HibernateSupportDao;
import com.nchu.hibnernate.support.Page;
import com.nchu.util.ReflectionUtils;

@Service
public class BaseService<T>{

	@Autowired
	@Qualifier(value = "hibernateSupportDao")

	private HibernateSupportDao<T, Integer> dao;

	@Transactional
	public void delete(T entity) {
		dao.delete(entity);
	}

	public void update(T entity) {
		String string = ReflectionUtils.invokeGetterMethod(entity, "id").toString();
		T t = dao.get(entity.getClass(),Integer.parseInt(string));
		List<Field> accessibleFields = ReflectionUtils.getAccessibleFields(entity.getClass(), true);
		Object value;
		for (Field field : accessibleFields) {
			try {
				if (isBase(field.getType())) {
					value = ReflectionUtils.invokeGetterMethod(entity, field.getName());
					if (value != null) {
						ReflectionUtils.invokeSetterMethod(t, field.getName(), value, field.getType());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dao.update(t);
	}

	@Transactional
	public void save(T entity) {
		dao.save(entity);
	}

	public List<T> loadAll(T entity) {
		String name = entity.getClass().getSimpleName();
		StringBuilder hql = new StringBuilder();
		hql.append("from " + name + " where 1=1");
		List<Field> accessibleFields = ReflectionUtils.getAccessibleFields(entity.getClass(), true);
		Object value = null;
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field : accessibleFields) {
			try {
				if (isBase(field.getType())) {
					value = ReflectionUtils.invokeGetterMethod(entity, field.getName());
					if (value != null) {
						map.put(field.getName(), value);
						hql.append(" and " + field.getName() + "=:" + field.getName());
					}
				}
			} catch (Exception e) {
			}

		}

		return dao.createQuery(hql.toString(), map).list();
	}

	@SuppressWarnings("unchecked")
	public Page<T> page(Page page) {
		String name = page.getClass().getSimpleName();
		StringBuilder hql = new StringBuilder();
		hql.append("from " + name + " where 1=1");
		List<Field> accessibleFields = ReflectionUtils.getAccessibleFields(page.getClass(), true);
		Object value = null;
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field : accessibleFields) {
			try {

				if (isBase(field.getType())) {
					value = ReflectionUtils.invokeGetterMethod(page, field.getName());

					if (value != null) {
						map.put(field.getName(), value);
						hql.append(" and " + field.getName() + "=:" + field.getName());
					}
				}
			} catch (Exception e) {
			}
		}
		page= dao.findPage(page, dao.createQuery(hql.toString(), map));
		//设置总页数
		return page;
	}

	public T getOne(Class clazz, Integer pk) {
		return (T) dao.getSession().load(clazz, pk);
	}
	private boolean isBase(Class clazz) {

		if (clazz.equals(Boolean.class) || clazz.equals(String.class) || clazz.equals(Integer.class)
				|| clazz.equals(Double.class) || clazz.equals(Date.class) | clazz.equals(Long.class)) {
			return true;
		}
		return false;
	}
}
