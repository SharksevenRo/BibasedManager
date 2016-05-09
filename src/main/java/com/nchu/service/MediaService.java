package com.nchu.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.nchu.model.TbMedia;
import com.nchu.model.TbTask;

@Service
public class MediaService extends BaseService<TbMedia>{
	
	public List<TbMedia> getAll(TbMedia media){
		Criterion [] criterions = null;
		if(media.getOwner()!=null){
			criterions=new Criterion[]{Restrictions.eq("owner", media.getOwner())};
		}
		if(media.getReceiver()!=null){
			criterions=new Criterion[]{Restrictions.eq("receiver", media.getReceiver())};
		}
		return dao.getEntitiestNotLazy(new TbMedia(), new String[]{"owner","receiver"},criterions);
	}
}
