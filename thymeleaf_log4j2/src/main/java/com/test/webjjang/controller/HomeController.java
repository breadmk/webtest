package com.test.webjjang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.webjjang.Service.AcademyServiceImpl;
import com.test.webjjang.model.AcademyModel;

@Controller
public class HomeController {
	 
	@Autowired
	AcademyServiceImpl academyServiceimpl;
	
	 @RequestMapping("/index")
	    public String hello(Model model) {
			List<AcademyModel> list = academyServiceimpl.list();
			model.addAttribute("list", list);
			return "/index/index";
	    }
	 
}
