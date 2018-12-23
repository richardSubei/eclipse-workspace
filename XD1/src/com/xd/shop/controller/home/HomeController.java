package com.xd.shop.controller.home;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xd.shop.po.CategoryFirst;
import com.xd.shop.service.CategoryService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("home.action")
	public String Home(HttpSession session) {
		List<CategoryFirst> list = categoryService.find();
		session.setAttribute("list", list);
		return "/home/index.jsp";
	}
	
	
	
	
	
	
	
}
