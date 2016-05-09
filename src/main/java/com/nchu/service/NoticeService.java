package com.nchu.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.nchu.model.TbMedia;
import com.nchu.model.TbNotice;

@Service
public class NoticeService extends BaseService<TbNotice>{

	public List<TbNotice> getAll(TbNotice notice){
		
		Criterion [] criterions = null;
		if(notice.getSender()!=null){
			criterions=new Criterion[]{Restrictions.eq("sender", notice.getSender())};
		}
		if(notice.getReceiver()!=null){
			criterions=new Criterion[]{Restrictions.eq("receiver", notice.getReceiver())};
		}
		
		if(notice.getTeavisible()!=null){
			criterions=new Criterion[]{Restrictions.eq("teavisible", notice.getTeavisible())};
		}
		if(notice.getStuvisible()!=null){
			criterions=new Criterion[]{Restrictions.eq("stuvisible", notice.getStuvisible())};
		}
		
		if(notice.getTeavisible()!=null&&notice.getSender()!=null){
			Criterion [] criterion1 = new Criterion[]{Restrictions.eq("teavisible", notice.getTeavisible()),Restrictions.eq("receiver", notice.getReceiver())};
			criterions=new Criterion[]{Restrictions.or(criterion1)};
		}
		return dao.getEntitiestNotLazy(new TbNotice(), new String[]{"sender","receiver"},criterions);
	}
}
