package com.nchu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.hibnernate.support.Page;
import com.nchu.model.TbGrade;
import com.nchu.service.BaseService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class GradeController {
	@Autowired
	private BaseService<TbGrade> baseService;

    @RequestMapping("/admin/grade/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbGrade grade) {

        try {
            baseService.save(grade);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/grade/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbGrade grade) {

        try {
            baseService.update(grade);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/TbGrade/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbGrade grade) {

        try {
            grade = baseService.getOne(grade.getClass(), grade.getId());
            baseService.delete(grade);
            return new MessageBean(APPConstant.ERROR, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBean(APPConstant.ERROR, "删除失败");
        }
    }

    @RequestMapping("/admin/grade/page")
    @ResponseBody
    public List<TbGrade> page(TbGrade grade) {

        try {
            return baseService.loadAll(grade);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/admin/grade/getOneAjax")
    @ResponseBody
    public TbGrade getOne(TbGrade grade) {
        try {
            return baseService.getOne(grade.getClass(), grade.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
