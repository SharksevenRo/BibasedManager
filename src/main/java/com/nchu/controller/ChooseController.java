package com.nchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.model.TbChoose;
import com.nchu.service.ChooseService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class ChooseController {
	@Autowired
	private ChooseService baseService;

    @RequestMapping("/admin/choose/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbChoose choose) {

        try {
            baseService.save(choose);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/choose/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbChoose choose) {

        try {
            baseService.update(choose);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/choose/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbChoose choose) {

        try {
            choose = baseService.getOne(choose.getClass(), choose.getId());
            baseService.delete(choose);
            return new MessageBean(APPConstant.ERROR, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "删除失败");
        }
    }

    @RequestMapping("/admin/choose/mytask")
    @ResponseBody
    public List<TbChoose> page(TbChoose choose) {

        try {
            return baseService.getAll(choose);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/admin/choose/getOneAjax")
    @ResponseBody
    public TbChoose getOne(TbChoose choose) {
        try {
            return baseService.getOne(choose.getClass(), choose.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
