package com.xd.shop.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xd.shop.po.CategoryFirst;
import com.xd.shop.po.CategorySecond;
import com.xd.shop.service.CategorySecondService;
import com.xd.shop.service.CategoryService;

@Controller
public class CategorySecondController {

	@Resource
	private CategorySecondService categorySecondService;
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping(value="/findAllCategoryS.action")
	public String findAllCategoryS(Model model) {
		List<CategorySecond> list = categorySecondService.find();
		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("msg", "查询为空");
		}
		return "admin/categorysecond/list.jsp";
	}
	
	@RequestMapping(value="toCategorySAdd.action")
	public String toCategorySAdd(Model model) {
		List<CategoryFirst> list = categoryService.findForSelect();
		model.addAttribute("list", list);
		return "admin/categorysecond/add.jsp";
	}
	@RequestMapping(value="categorySSave.action")
	public String categorySSave(String categoryFId, String categorySName) {
		CategorySecond categorySecond = new CategorySecond();
		CategoryFirst categoryFirst = categoryService.findCategoryFById(categoryFId);
		categorySecond.setCategorySName(categorySName);
		categorySecond.setCategoryFirst(categoryFirst);
		int i = categorySecondService.insert(categorySecond);
		if (i == 1) {
			System.out.println("成功");
			return "redirect: toCategorySAdd.action";
		} else {
			return "error/error.jsp";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
