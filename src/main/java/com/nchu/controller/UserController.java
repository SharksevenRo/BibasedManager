package com.nchu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.model.TbChoose;
import com.nchu.model.TbRoleFunction;
import com.nchu.model.TbUser;
import com.nchu.service.ChooseService;
import com.nchu.service.RoleFunctionService;
import com.nchu.service.UserService;
import com.nchu.util.Md5;
import com.nchu.web.support.MenuRender;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class UserController {

	@Autowired
	private UserService baseService;
	@Autowired
	private ChooseService chooseService;
	@Autowired
	@Qualifier("roleFunctionService")
	private RoleFunctionService<TbRoleFunction> roleFunctionService;
	private String path;
	private static int bufSize = 512; // size of bytes
	private byte[] buf;
	private int readedBytes;

	@RequestMapping("/user/register")
	public void register(Model model, HttpServletRequest request, HttpServletResponse response, TbUser user) {

		try {
			TbUser temp = new TbUser();
			temp.setCode(user.getCode());
			if (baseService.loadAll(temp).size() > 1) {
				model.addAttribute("errors", "该学号已经注册");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			user.setPassword(Md5.GetMD5Code(user.getPassword()));
			baseService.save(user);
			request.getSession().setAttribute("user", user);
			loadAll(request, user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/user/login")
	public String login(TbUser user, HttpServletRequest request) {

		try {
			user.setCode(user.getCode().trim());
			user.setPassword(Md5.GetMD5Code(user.getPassword()));
			List<TbUser> loadAll = baseService.loadAll(user);
			if (loadAll.size() == 1) {
				TbUser tbUser = loadAll.get(0);
				if (user.getPassword().equals(tbUser.getPassword()) && user.getCode().equals(tbUser.getCode())) {
					loadAll(request, tbUser);
					request.getSession().setAttribute("user", tbUser);
					return "/index";
				}
			}

			return "/login";
		} catch (Exception e) {
			e.printStackTrace();
			return "/erro/404.html";
		}

	}

	private void loadAll(HttpServletRequest request, TbUser tbUser) {
		List<MenuRender> renders = new ArrayList<MenuRender>();
		MenuRender render;
		List<TbRoleFunction> loadAll2 = roleFunctionService.loadAll(new TbRoleFunction(tbUser.getRoleId(), null));
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

	@RequestMapping("/admin/user/page")
	@ResponseBody
	public List<TbUser> page(TbUser user) {

		try {
			return baseService.getAll(user);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 选择课题
	 * 
	 * @param choose
	 * @param request
	 * @return
	 */
	@RequestMapping("/stduent/chooseAjax")
	@ResponseBody
	public MessageBean chooseTask(TbChoose choose, HttpServletRequest request) {

		TbUser user = (TbUser) request.getSession().getAttribute("user");
		TbChoose temp = new TbChoose();
		temp.setStudentId(user.getId());
		if (chooseService.loadAll(temp).size() == 1) {
			return new MessageBean(APPConstant.ERROR, "你已经选择了该课题");
		} else {
			choose.setStudentId(user.getId());
			temp = new TbChoose();
			temp.setStudentId(user.getId());
			if (chooseService.loadAll(temp).size() > 2) {
				return new MessageBean(APPConstant.ERROR, "你已经选了两个课题");
			} else {
				chooseService.save(choose);
				return new MessageBean(APPConstant.SUCCESS, "选择成功");
			}
		}
	}

	@RequestMapping("/stduent/chooseTeacher")
	@ResponseBody
	public MessageBean chooseTask(TbUser teacher, HttpServletRequest request) {

		TbUser user = (TbUser) request.getSession().getAttribute("user");
		if (user.getTeacher() != null) {
			return new MessageBean(APPConstant.ERROR, "你已经选择了毕设老师，不能重复选择");
		} else {
			user.setTeacher(teacher.getId());
			baseService.update(user);
			return new MessageBean(APPConstant.SUCCESS, "选择成功，可以前往去查看和选择课题");
		}
	}
	@RequestMapping("/admin/user/logout")
	public void loginout(HttpServletRequest request,HttpServletResponse response){
		  
		HttpSession session1 = request.getSession();
		session1.invalidate();
		try {
			response.sendRedirect("http://localhost:8080/BibasedManager/login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
