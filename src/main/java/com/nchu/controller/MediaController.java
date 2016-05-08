package com.nchu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.hibnernate.support.Page;
import com.nchu.model.TbMedia;
import com.nchu.model.TbRole;
import com.nchu.service.BaseService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class MediaController {
	@Autowired
	private BaseService<TbMedia> baseService;

    @RequestMapping("/admin/meadia/saveAjax")
    @ResponseBody
    public MessageBean saveAjax(TbMedia meadia) {

        try {
            baseService.save(meadia);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/meadia/updateAjax")
    @ResponseBody
    public MessageBean updateAjax(TbMedia meadia) {

        try {
            baseService.update(meadia);
            return new MessageBean(APPConstant.SUCCESS, "上传成功");
        } catch (Exception e) {
            return new MessageBean(APPConstant.SUCCESS, "上传失败");
        }
    }

    @RequestMapping("/admin/TbMedia/deleteAjax")
    @ResponseBody
    public MessageBean deleteAjax(TbMedia meadia) {

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
    public Page<TbMedia> page(Page<TbMedia> meadiaPage) {

        try {
            return baseService.page(meadiaPage);
        } catch (Exception e) {
            Page<TbMedia> page = new Page<TbMedia>();
            page.setCode(APPConstant.ERROR);
            page.setMessage("服务器忙");
            return page;
        }
    }

    @RequestMapping(value = "/admin/meadia/getOneAjax")
    @ResponseBody
    public TbMedia getOne(TbMedia meadia) {
        try {
            return baseService.getOne(meadia.getClass(), meadia.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
