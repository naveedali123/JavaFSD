package com.company.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.company.sportyshoes.dao.SportyShoesDAO;
import com.company.sportyshoes.entity.Product;

@Controller
public class PageNavigatorController {
	
	@Autowired
	SportyShoesDAO sportyShoesDAO;

	@GetMapping("/adminCP")
	public String gotoAdminCP() {
		return "changeAdminPassword";
	}
	
	@GetMapping("/dashboard")
	public String gotoDashboad() {
		return "adminDashboard";
	}
	
	@GetMapping("/searchUser")
	public String gotoSearchUser() {
		return "searchUserPage";
	}
	
	@GetMapping("/addProduct")
	public String gotoAddProduct() {
		return "addProductPage";
	}
	
	@GetMapping("/updateProduct")
	public String gotoUpdateProduct(Model model) {
		
		List<Product> productList = sportyShoesDAO.getProducts();
		model.addAttribute("productList", productList);
		
		return "updateProductPage";
	}
	
	@GetMapping("/deleteProduct")
	public String gotoDeleteProduct(Model model) {
		List<Product> productList = sportyShoesDAO.getProducts();
		model.addAttribute("productList", productList);
		return "deleteProductPage";
	}
	
	@GetMapping("/purchaseOrder")
	public String gotoPurchaseOrder() {
		return "purchaseOrderPage";
	}
}
