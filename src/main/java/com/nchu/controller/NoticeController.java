package com.nchu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.model.TbNotice;
import com.nchu.model.TbUser;
import com.nchu.service.NoticeService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService baseService;

    @RequestMapping("/admin/notice/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbNotice notice,HttpServletRequest request) {
    	TbUser user = (TbUser) request.getSession().getAttribute("user");
        try {
        	
        	if(notice.getReceiver().getId()==user.getId()){
        		notice.setTeavisible((short) 1);
        	}
            baseService.save(notice);
            return new MessageBean(APPConstant.SUCCESS, "发布成功");
        } catch (Exception e) {
        	e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "发布失败");
        }
    }

    @RequestMapping("/admin/notice/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbNotice notice) {

        try {
            baseService.update(notice);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/notice/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbNotice notice) {

        try {
            notice = baseService.getOne(notice.getClass(), notice.getId());
            baseService.delete(notice);
            return new MessageBean(APPConstant.ERROR, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "删除失败");
        }
    }

    @RequestMapping("/admin/notice/page")
    @ResponseBody
    public List<TbNotice> page(TbNotice notice) {

        try {
            return baseService.getAll(notice);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/admin/notice/getOneAjax")
    @ResponseBody
    public TbNotice getOne(TbNotice notice) {
        try {
        	
            return baseService.getOne(notice.getClass(), notice.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
