package com.nchu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.model.TbRoleFunction;
import com.nchu.model.TbUser;
import com.nchu.service.BaseService;
import com.nchu.service.RoleFunctionService;
import com.nchu.util.Md5;
import com.nchu.web.support.MenuRender;

@Controller
public class UserController {

	@Autowired
	@Qualifier("baseService")
	private BaseService<TbUser> baseService;
	@Autowired
	@Qualifier("roleFunctionService")
	private RoleFunctionService<TbRoleFunction> roleFunctionService;

	@RequestMapping("/user/register")
	public String register(HttpServletRequest request,TbUser user) {

		try {
			user.setPassword(Md5.GetMD5Code(user.getPassword()));
			user.setRoleId(1);
			baseService.save(user);
			loadAll(request, user);
			return "/index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/erro/404.html";
		}

	}

	@RequestMapping("/user/login")
	public String login(TbUser user, HttpServletRequest request) {

		try {
			user.setPassword(Md5.GetMD5Code(user.getPassword()));
			List<TbUser> loadAll = baseService.loadAll(user);
			if (loadAll.size() == 1) {
				TbUser tbUser = loadAll.get(0);
				if (user.getPassword().equals(tbUser.getPassword()) && user.getCode().equals(tbUser.getCode())) {
					loadAll(request, tbUser);
					return "/index";
				}
			}

			return "/error/404.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "/erro/404.html";
		}

	}

	private void loadAll(HttpServletRequest request,TbUser tbUser) {
		List<MenuRender> renders = new ArrayList<MenuRender>();
		MenuRender render;
		List<TbRoleFunction> loadAll2 = roleFunctionService
				.loadAll(new TbRoleFunction(tbUser.getRoleId(), null));
		for (TbRoleFunction tbRoleFunction : loadAll2) {

			if (tbRoleFunction.getParentId() == 0) {
				render = new MenuRender();
				render.setId(tbRoleFunction.getId());
				render.setFunctionUrl(tbRoleFunction.getFunctionUrl());
				render.setName(tbRoleFunction.getName());
				renders.add(render);
			}
		}
		List<MenuRender> child;
		for (MenuRender render1 : renders) {
			child = new ArrayList<MenuRender>();
			for (TbRoleFunction tbRoleFunction : loadAll2) {
				render = new MenuRender();
				if (tbRoleFunction.getId() != 0) {
					if (render1.getId().equals(tbRoleFunction.getParentId())) {
						render = new MenuRender();
						render.setFunctionUrl(tbRoleFunction.getFunctionUrl());
						render.setName(tbRoleFunction.getName());
						child.add(render);
						render1.setChild(child);
					}
				}
			}
		}
		request.getSession().setAttribute("menus", renders);
	}
}
