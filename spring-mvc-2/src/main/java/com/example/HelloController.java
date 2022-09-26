package com.example;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav) 
	{
		mav.setViewName("login"); //login.jsp
		return mav;
	}
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(ModelAndView mav, 
			@RequestParam(value = "ID", required = false) String id,
			@RequestParam(value = "Pwd", required = false) String pwd) 
			{
		
				if(id.equals("aaa")&&pwd.equals("1234"))
					mav.addObject("Login_Ok",true);
				else
					mav.addObject("Login_Ok",false);
				mav.setViewName("loginCheck"); //login.jsp
				return mav;
			}
}