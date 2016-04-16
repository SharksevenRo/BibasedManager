package com.nchu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nchu.model.TbRoleFunction;

@Service
public class RoleFunctionService<T> extends BaseService<TbRoleFunction>{

	@Override
	public List<TbRoleFunction> loadAll(TbRoleFunction entity) {
		return super.loadAll(entity);
	}
}
