package com.mydairy.business;

import java.util.List;

import com.mydairy.entities.Entry;



public interface EntryBusiness 
{
	public void save(Entry entry);//Insert Query
	
	public void update(Entry entry); //Update Query
	
	public void delete(Entry entry);//Delete Query
	
	public Entry findById(int id);//Select by where clause
	
	public List<Entry> findAll();//select all
	
	public List<Entry> findEntrybyUserId(int id);
	
	

}
