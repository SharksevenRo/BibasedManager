package com.nchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.hibnernate.support.Page;
import com.nchu.model.TbMessageRead;
import com.nchu.service.BaseService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

public class MessageReadController {
	@Autowired
	private BaseService<TbMessageRead> baseService;

    @RequestMapping("/admin/meadia/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbMessageRead meadia) {

        try {
            baseService.save(meadia);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/meadia/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbMessageRead meadia) {

        try {
            baseService.update(meadia);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/TbMessageRead/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbMessageRead meadia) {

        try {
            meadia = baseService.getOne(meadia.getClass(), meadia.getId());
            baseService.delete(meadia);
            return new MessageBean(APPConstant.ERROR, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "删除失败");
        }
    }

    @RequestMapping("/admin/meadia/page")
    @ResponseBody
    public List<TbMessageRead> page(TbMessageRead meadiaPage) {

        try {
            return baseService.loadAll(meadiaPage);
        } catch (Exception e) {
           return null;
        }
    }

    @RequestMapping(value = "/admin/meadia/getOneAjax")
    @ResponseBody
    public TbMessageRead getOne(TbMessageRead meadia) {
        try {
            return baseService.getOne(meadia.getClass(), meadia.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
