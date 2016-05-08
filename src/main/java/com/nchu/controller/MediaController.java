package com.nchu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.Media;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nchu.hibnernate.support.Page;
import com.nchu.model.TbMedia;
import com.nchu.model.TbRole;
import com.nchu.model.TbUser;
import com.nchu.service.BaseService;
import com.nchu.service.MediaService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class MediaController {
	@Autowired
	private MediaService baseService;

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

	@RequestMapping("/admin/media/page")
	@ResponseBody
	public List<TbMedia> page(TbMedia meadia, HttpServletRequest request) {

		try {
			TbUser user = (TbUser) request.getSession().getAttribute("user");
			if (user.getRoleId() == 3) {
				meadia.setReceiver(user);
			}
			if (user.getRoleId() == 1) {
				meadia.setOwner(user);
			}
			return baseService.getAll(meadia);
		} catch (Exception e) {
			return null;
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

	@RequestMapping(value = "/admin/meadia/upload")
	@ResponseBody
	public MessageBean uploadDocs(MultipartFile file, HttpServletRequest request) {

		try {
			TbUser user = (TbUser) request.getSession().getAttribute("user");
			String path = request.getRealPath("/");
			String tempPath = "docs/temp/";
			TbMedia media = new TbMedia();

			media.setName(file.getOriginalFilename());
			String[] split = file.getOriginalFilename().split("[.]");
			String fileName = UUID.randomUUID() + "." + split[split.length - 1];

			TbUser newuser = new TbUser();
			newuser.setId(user.getTeacher());
			media.setOwner(user);
			media.setReceiver(newuser);
			File newFile = new File(path + tempPath);
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			newFile = new File(path + tempPath + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			inputstreamtofile(file.getInputStream(), newFile);
			media.setUrl(tempPath + fileName);
			baseService.save(media);
			return new MessageBean(APPConstant.SUCCESS, "上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new MessageBean(APPConstant.SUCCESS, "上传失败");
		}

	}

	@RequestMapping(value = "/admin/media/download")
	public void download(TbMedia media, HttpServletRequest request, HttpServletResponse response) {
		try {
			TbMedia one = baseService.getOne(TbMedia.class, media.getId());
			String path = request.getRealPath("/");
			File file = new File(path  + one.getUrl());

			FileInputStream outInputStream = new FileInputStream(file);
			response.setHeader("Content-Disposition", "attachment;filename="
					+encodeChineseDownloadFileName(request,one.getName()));
			ServletOutputStream outputStream = response.getOutputStream();

	        byte[] b = new byte[2048];
	        int i;
	        while ((i = outInputStream.read(b)) != -1) {
	        	outputStream.write(b, 0, i);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inputstreamtofile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String encodeChineseDownloadFileName(  
	        HttpServletRequest request, String pFileName) throws UnsupportedEncodingException {  
	      
	     String filename = null;    
	        String agent = request.getHeader("USER-AGENT");    
	        if (null != agent){    
	            if (-1 != agent.indexOf("Firefox")) {//Firefox    
	                filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8"))))+ "?=";    
	            }else if (-1 != agent.indexOf("Chrome")) {//Chrome    
	                filename = new String(pFileName.getBytes(), "ISO8859-1");    
	            } else {//IE7+    
	                filename = java.net.URLEncoder.encode(pFileName, "UTF-8");    
	                filename =filename.replace(" ", "%20");//替换空格    
	            }    
	        } else {    
	            filename = pFileName;    
	        }    
	        return filename;   
	}  
	
	
	@RequestMapping(value = "/admin/media/score")
	@ResponseBody
	public MessageBean score(TbMedia media){
		
		try {
			baseService.update(media);
			return new MessageBean(APPConstant.SUCCESS, "打分成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new MessageBean(APPConstant.ERROR, "打分失败");
		}
		
	}
}
