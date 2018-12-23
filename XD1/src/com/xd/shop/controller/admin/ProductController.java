package com.xd.shop.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xd.shop.po.CategorySecond;
import com.xd.shop.po.Product;
import com.xd.shop.po.ProductImg;
import com.xd.shop.service.CategorySecondService;
import com.xd.shop.service.ProductImgService;
import com.xd.shop.service.ProductService;

@Controller
public class ProductController {
	
	@Resource
	private CategorySecondService categorySecondService;
	@Resource
	private ProductService productService;
	@Resource
	private ProductImgService productImgService;
	
	@RequestMapping(value="findAllProduct.action")
	public String findAllProduct(Model model) {
		List<Product> list = productService.find();
		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("list", null);
		}
		return "admin/product/list.jsp";
	}
	
	@RequestMapping(value="toProductAdd.action")
	public String toProductAdd(Model model) {
		List<CategorySecond> list = categorySecondService.find();
		model.addAttribute("list", list);
		return "admin/product/add.jsp";
	}
	
	@RequestMapping(value="productSave.action")
	public String productSave(@RequestParam("productImgs") MultipartFile file, String productNo, String productName, double productPrice, int inventory, String categorySId, HttpServletRequest request) throws IllegalStateException, IOException {
		String path = request.getRealPath("image") +  "/" +file.getOriginalFilename();
		Product product = new Product();
		ProductImg productImg = new ProductImg();
		String id = UUID.randomUUID().toString();
		product.setProductId(id);
		productImg.setProductId(id);
		product.setProductNo(productNo);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setInventory(inventory);
		product.setCategorySId(categorySId);
		product.setProductRemark("");
		product.setProductStatus(1);
		product.setProductSalesTotal(0);
		productImg.setProductImgId(UUID.randomUUID().toString());
		productImg.setProductImg(path);
		productImg.setImgOrder(1);
		productImg.setImgStatus(1);
		productService.insert(product);
		productImgService.insert(productImg);
		File localFile = new File(path);
		file.transferTo(localFile);
		return "redirect:findAllProduct.action";
	}
}
