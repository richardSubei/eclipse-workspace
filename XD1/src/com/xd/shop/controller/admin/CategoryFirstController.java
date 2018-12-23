package com.xd.shop.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xd.shop.po.CategoryFirst;
import com.xd.shop.po.CategorySecond;
import com.xd.shop.service.CategorySecondService;
import com.xd.shop.service.CategoryService;

@Controller
public class CategoryFirstController {

	@Resource
	private CategoryService categoryService;
	@Resource
	private CategorySecondService categorySecondService;
	
	@RequestMapping(value="findAllCategoryF.action")
	public String findAllCategoryFirst(Model model) {
		List<CategoryFirst> list = categoryService.find();
		model.addAttribute("list", list);
		return "admin/category/list.jsp";
	}
	
	@RequestMapping(value="toCategoryFEdit.action")
	public String toCategoryFEdit(String categoryFId, Model model) {
		CategoryFirst categoryFirst = categoryService.findCategoryFById(categoryFId);
		model.addAttribute("categoryFirst", categoryFirst);
		return "/admin/category/edit.jsp";
	}
	@RequestMapping(value="categoryFupdate.action")
	public String categoryFupdate(String categoryFId, String categoryFName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("categoryFId", categoryFId);
		map.put("categoryFName", categoryFName);
		categoryService.updateCategoryF(map);
		return "redirect: findAllCategoryF.action";
	}
	@RequestMapping(value="toCategoryFAdd.action")
	public String toCategoryFAdd() {
		return "admin/category/add.jsp";
	}
	@RequestMapping(value="categoryFSave.action")
	public String categoryFSave(CategoryFirst categoryFirst, Model model) {
		categoryFirst.setCategoryFStatus(1);
		int i = categoryService.insert(categoryFirst);
		if (i == 1) {
			return "redirect: findAllCategoryF.action";
		} else {
			model.addAttribute("msg", "添加失败");
			return "admin/category/add.jsp";
		}
	}
	@RequestMapping(value="categoryFDel.action")
	public String categoryFDel(String categoryFId, Model model) {
		categorySecondService.deleteBatch(categoryFId);
		int i = categoryService.delete(categoryFId);
		if (i == 1) {
			System.out.println("删除成功");
			return "redirect: findAllCategoryF.action";
		} else {
			model.addAttribute("msg", "删除失败");
			return "error/error.jsp";
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
