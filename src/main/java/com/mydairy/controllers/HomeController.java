package com.mydairy.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mydairy.business.EntryBusiness;
import com.mydairy.business.UserBusiness;
import com.mydairy.entities.Entry;
import com.mydairy.entities.User;

@Controller
public class HomeController 
{
	@Autowired
	private UserBusiness userBusiness;
	
	@Autowired
	private EntryBusiness entryBusiness;
	
	@Autowired
	HttpSession httpSession;

	@RequestMapping("/index")
	public ModelAndView indexPage()
	{
		//In the constructor pass the file name(prefix) of view
		ModelAndView model=new ModelAndView("index");

		return model;

	}
	@RequestMapping("/home")
	public ModelAndView homePage()
	{
		//In the constructor pass the file name(prefix) of view
		ModelAndView model=new ModelAndView("home");

		return model;

	}
	
	@RequestMapping("/register")
	public ModelAndView registerPage()
	{
		//In the constructor pass the file name(prefix) of view
		ModelAndView model=new ModelAndView("registerForm");

		return model;

	}
	
	@RequestMapping("/userRegister")
	public ModelAndView userRegistered(@ModelAttribute("user") User user)
	{
		//In the constructor pass the file name(prefix) of view
		ModelAndView model=new ModelAndView("registerSuccess");
		userBusiness.save(user);
		
		return model;

	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authenticateUser(@ModelAttribute("user") User user)
	{
		//In the constructor pass the file name(prefix) of view
		ModelAndView model=new ModelAndView("home");
		User result=userBusiness.findUserByName(user.getUsername());
		if(result==null)
		{
			model.setViewName("registerForm");
		}
		else if(result!=null && user.getPassword().equals(result.getPassword()))
		{
			model.setViewName("userEntry");
		
			
			model.addObject("username", result.getUsername());
			
			httpSession.setAttribute("user", result);
			
			
			List<Entry> entry=null;
			try
			{
			entry=entryBusiness.findEntrybyUserId(result.getId());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			model.addObject("entries", entry);
		}
		return model;
	
	}
	
	@RequestMapping("/addEntry")
	public ModelAndView saveEntry(@RequestParam("username") String username)
	{
		//In the constructor pass the file name(prefix) of view
		ModelAndView model=new ModelAndView("addEntryForm");
		model.addObject("username",username);
		
		return model;

	}
	
	@RequestMapping("/logEntry")
	public ModelAndView logEntry(@ModelAttribute("entry") Entry entry)
	{
		//In the constructor pass the file name(prefix) of view
		ModelAndView model=new ModelAndView("userEntry");
		entryBusiness.save(entry);
		
		User result=(User) httpSession.getAttribute("user");
		
		List<Entry> entries=null;
		try
		{
		entries=entryBusiness.findEntrybyUserId(result.getId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		model.addObject("username",result.getUsername());
		model.addObject("entries", entries);
		
		return model;
	}
	@RequestMapping("/viewEntry")
	public ModelAndView viewEntry(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView("displayEntry");
		User result=(User) httpSession.getAttribute("user");
		Entry entry=entryBusiness.findById(id);
		model.addObject("entry",entry);
		model.addObject("username",result.getUsername());
		return model;
	}
	
	@RequestMapping("/userEntryHome")
	public ModelAndView userEntryHome()
	{
		ModelAndView model=new ModelAndView("userEntry");
		User result=(User) httpSession.getAttribute("user");
		model.addObject("username",result.getUsername());
		List<Entry> entries=null;
		try
		{
		entries=entryBusiness.findEntrybyUserId(result.getId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		model.addObject("entries", entries);
		
		return model;
	}
	
	@RequestMapping("/updateEntry")
	public ModelAndView updateEntry(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView("displayUpdateEntry");
		User result=(User) httpSession.getAttribute("user");
		Entry entry=entryBusiness.findById(id);
		model.addObject("entry",entry);
		model.addObject("username",result.getUsername());
		return model;

	}
	@RequestMapping("/processUpdated")
	public ModelAndView processUpdated(@ModelAttribute("entry") Entry entry)
	{
		ModelAndView model=new ModelAndView("userEntry");
		entryBusiness.update(entry);
		
		User result=(User) httpSession.getAttribute("user");
		
		List<Entry> entries=null;
		try
		{
		entries=entryBusiness.findEntrybyUserId(result.getId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		model.addObject("entries", entries);
		model.addObject("username",result.getUsername());
		return model;

	}
	
	@RequestMapping("/deleteEntry")
	public ModelAndView deleteEntry(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView("userEntry");
		Entry entry=entryBusiness.findById(id);
		
		entryBusiness.delete(entry);
		
		User result=(User) httpSession.getAttribute("user");
		
		List<Entry> entries=null;
		try
		{
		entries=entryBusiness.findEntrybyUserId(result.getId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		model.addObject("entries", entries);
		model.addObject("username",result.getUsername());
		return model;

	}
	
	@RequestMapping("/signout")
	public ModelAndView signout()
	{
		ModelAndView model=new ModelAndView("home");
		
		httpSession.invalidate();
		return model;

	}
	

}
