package com.nchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.model.TbTask;
import com.nchu.service.BaseService;
import com.nchu.util.LazyObjecUtil;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class TaskController {

	@Autowired
	private BaseService<TbTask> baseService;
	
	@RequestMapping("/teacher/task")
	public String all(Model model){
		
		try {
			List<TbTask> loadAll = baseService.loadAll(new TbTask());
			model.addAttribute("tasks", loadAll);
			loadAll=LazyObjecUtil.LazySetNull(loadAll, "tbUser");
			return "/pages/tasks";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/errors/404.html";
	}
	@RequestMapping("/teacher/task/save")
	@ResponseBody
	public MessageBean save(TbTask task){
	
		try {
			baseService.save(task);
			return new MessageBean(APPConstant.SUCCESS, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new MessageBean(APPConstant.ERROR, "服务器异常");
		}
	}
}
