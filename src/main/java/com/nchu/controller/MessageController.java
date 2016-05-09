package com.nchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.model.TbMessage;
import com.nchu.service.MessageService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class MessageController {
	@Autowired
	private MessageService baseService;

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
    public List<TbMessage> page(TbMessage messagePage) {

        try {
            return baseService.getAll(messagePage);
        } catch (Exception e) {
           return null;
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
