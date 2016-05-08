package com.nchu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.model.TbTask;
import com.nchu.model.TbUser;
import com.nchu.service.TaskService;
import com.nchu.service.UserService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class TaskController {

	@Autowired
	private TaskService baseService;
	@Autowired
	private UserService userService;
	
	/*@RequestMapping("/teacher/task")
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
*/
    @RequestMapping("/admin/task/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbTask task,HttpServletRequest request) {

        try {
        	
        	TbUser user=(TbUser) request.getSession().getAttribute("user");
        	task.setPublisher(user.getId());
            baseService.save(task);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }
    @RequestMapping("/admin/task/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbTask task) {

        try {
            baseService.update(task);
            return new MessageBean(APPConstant.SUCCESS, "修改成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "修改失败");
        }
    }

    @RequestMapping("/admin/task/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbTask task) {

        try {
            task = baseService.getOne(task.getClass(), task.getId());
            baseService.delete(task);
            return new MessageBean(APPConstant.SUCCESS, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "删除失败");
        }
    }

    @RequestMapping("/admin/task/page")
    @ResponseBody
    public List<TbTask> page(HttpServletRequest request) {

        try {
        	TbUser user=(TbUser) request.getSession().getAttribute("user");
            return baseService.getAll(user.getId());
        } catch (Exception e) {
           return null;
        }
    }

    @RequestMapping(value = "/admin/task/getOneAjax")
    @ResponseBody
    public TbTask getOne(TbTask task) {
        try {
            return baseService.getOne(task.getClass(), task.getId());
        } catch (Exception e) {
            return null;
        }
    }
    
   
    

    @RequestMapping("/admin/task/student")
    @ResponseBody
    public List<TbTask> student(HttpServletRequest request) {

    	TbUser user=(TbUser) request.getSession().getAttribute("user");
    	TbTask task=new TbTask();
    	task.setPublisher(user.getTeacher());
    	try {
            return baseService.loadAll(task);
        } catch (Exception e) {
           return null;
        }
    }
}
