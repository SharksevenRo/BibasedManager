package com.nchu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.hibnernate.support.Page;
import com.nchu.model.TbMessage;
import com.nchu.service.BaseService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

public class MessageController {
	@Autowired
	private BaseService<TbMessage> baseService;

    @RequestMapping("/admin/message/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbMessage message) {

        try {
            baseService.save(message);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/message/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbMessage message) {

        try {
            baseService.update(message);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/TbMessage/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbMessage message) {

        try {
            message = baseService.getOne(message.getClass(), message.getId());
            baseService.delete(message);
            return new MessageBean(APPConstant.ERROR, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "删除失败");
        }
    }

    @RequestMapping("/admin/message/page")
    @ResponseBody
    public Page<TbMessage> page(Page<TbMessage> messagePage) {

        try {
            return baseService.page(messagePage);
        } catch (Exception e) {
            Page<TbMessage> page = new Page<TbMessage>();
            page.setCode(APPConstant.ERROR);
            page.setMessage("服务器忙");
            return page;
        }
    }

    @RequestMapping(value = "/admin/message/getOneAjax")
    @ResponseBody
    public TbMessage getOne(TbMessage message) {
        try {
            return baseService.getOne(message.getClass(), message.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
