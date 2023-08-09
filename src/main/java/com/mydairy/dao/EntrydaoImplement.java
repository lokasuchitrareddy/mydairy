package com.mydairy.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mydairy.entities.Entry;

@Component
public class EntrydaoImplement implements Entrydao 
{
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional(readOnly = false)
	public void save(Entry entry) 
	{
		hibernateTemplate.save(entry);
	}

	@Transactional(readOnly = false)
	public void update(Entry entry) 
	{
		hibernateTemplate.update(entry);

	}

	@Transactional(readOnly = false)
	public void delete(Entry entry) 
	{
		hibernateTemplate.delete(entry);

	}

	@Override
	public Entry findById(int id) 
	{
		return hibernateTemplate.get(Entry.class, id);
	}

	@Override
	public List<Entry> findAll() 
	{
		
		return hibernateTemplate.loadAll(Entry.class);
	}

	@Override
	public List<Entry> findEntrybyUserId(int id) 
	{
		DetachedCriteria criteria=DetachedCriteria.forClass(Entry.class);
		criteria.add(Restrictions.eq("userId",id));
		List<Entry> entry=null;
		try
		{
		 entry= (List<Entry>) hibernateTemplate.findByCriteria(criteria);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return entry;
	}

}
