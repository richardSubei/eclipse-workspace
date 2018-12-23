package com.xd.shop.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xd.shop.po.Admin;
import com.xd.shop.service.admin.AdminService;

@Controller
public class AdminController {

	@Resource
	private AdminService adminService;
	
	@RequestMapping(value="toAdminLogin.action")
	public String toAdminLogin() {
		return "admin/index.jsp";
	}
	
	@RequestMapping(value="/adminLogin.action")
	public String adminLogin(Admin admin, Model model, HttpServletRequest request) {
		Admin adminSelect = adminService.findByNameAndPwd(admin);
		if (adminSelect != null) {
			return "admin/home.jsp";			
		} else {
			model.addAttribute("msg", "用户名或者密码错误");
			return "admin/index.jsp";
		}
		
	}
	
	@RequestMapping(value="/top.action")
	public String top() {
		return "admin/top.jsp";
	}
	@RequestMapping(value="/left.action")
	public String left() {
		return "admin/left.jsp";
	}
	@RequestMapping(value="/welcome.action")
	public String welcome() {
		return "admin/welcome.jsp";
	}
	@RequestMapping(value="/bottom.action")
	public String bottom() {
		return "admin/bottom.jsp";
	}
}
