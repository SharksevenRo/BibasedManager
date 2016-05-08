package com.nchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.hibnernate.support.Page;
import com.nchu.model.TbGroup;
import com.nchu.service.BaseService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

public class GroupController {
	@Autowired
	private BaseService<TbGroup> baseService;

    @RequestMapping("/admin/group/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbGroup group) {

        try {
            baseService.save(group);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/group/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbGroup group) {

        try {
            baseService.update(group);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/TbGroup/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbGroup group) {

        try {
            group = baseService.getOne(group.getClass(), group.getId());
            baseService.delete(group);
            return new MessageBean(APPConstant.ERROR, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "删除失败");
        }
    }

    @RequestMapping("/admin/group/page")
    @ResponseBody
    public List<TbGroup> page(TbGroup groupPage) {

        try {
            return baseService.loadAll(groupPage);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/admin/group/getOneAjax")
    @ResponseBody
    public TbGroup getOne(TbGroup group) {
        try {
            return baseService.getOne(group.getClass(), group.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
