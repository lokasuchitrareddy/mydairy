package com.mydairy.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mydairy.dao.Entrydao;
import com.mydairy.entities.Entry;

@Component
public class EntryBusinessImplement implements EntryBusiness
{
	
	@Autowired
	Entrydao entrydao;

	@Override
	public void save(Entry entry)
	{
		entrydao.save(entry);
		
	}

	@Override
	public void update(Entry entry) 
	{
		entrydao.update(entry);
		
	}

	@Override
	public void delete(Entry entry) 
	{
		
		entrydao.delete(entry);
	}

	@Override
	public Entry findById(int id)
	{
	
		return entrydao.findById(id);
	}

	@Override
	public List<Entry> findAll() 
	{
		
		return entrydao.findAll();
	}

	@Override
	public List<Entry> findEntrybyUserId(int id) 
	{
		
		return entrydao.findEntrybyUserId(id);
	}

	

}
