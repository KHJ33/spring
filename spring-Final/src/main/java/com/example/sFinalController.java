package com.example;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class sFinalController {
	// same as @GetMapping("/hello")
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String hello(Model model,
			@RequestParam(value = "name", required = false) String name) 
			{
				model.addAttribute("greeting", "안녕하세요, " + name);
				return "start";
			}
}
