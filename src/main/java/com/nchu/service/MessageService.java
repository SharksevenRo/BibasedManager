package com.nchu.service;

import java.util.List;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.nchu.model.TbMessage;
import com.nchu.model.TbNotice;

@Service	
public class MessageService extends BaseService<TbMessage>{

	
	public List<TbMessage> getAll(TbMessage message){
		
		
		Criterion [] criterions = null;
		if(message.getSender()!=null){
			criterions=new Criterion[]{Restrictions.eq("sender", message.getSender()),Restrictions.isNull("parentId")};
		}
		if(message.getReceiver()!=null){
			criterions=new Criterion[]{Restrictions.eq("receiver", message.getReceiver()),Restrictions.isNull("parentId")};
		}
		
		
		List<TbMessage> messages = dao.getEntitiestNotLazy(new TbMessage(), new String[]{"sender","receiver"},criterions);
		
		for (TbMessage tbMessage : messages) {
			tbMessage.setChild(getChild(tbMessage));
		}
		return messages;
	}
	
	public List<TbMessage> getChild(TbMessage message){
		
		Criterion [] criterions = null;
		criterions=new Criterion[]{Restrictions.eq("parentId", message.getId())};
			
		List<TbMessage> messages = dao.getEntitiestNotLazyWithOrder(new TbMessage(), new String[]{"sender","receiver"},criterions,Order.desc("time"));
		return messages;
	}
}
