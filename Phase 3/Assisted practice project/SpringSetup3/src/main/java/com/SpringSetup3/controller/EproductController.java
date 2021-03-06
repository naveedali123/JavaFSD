package com.SpringSetup3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SpringSetup3.dao.EmployeeDAO;
import com.SpringSetup3.model.EProduct;



@Controller
public class EproductController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@GetMapping("/litProducts")
	public String listProducts(Model model) {
		
		List<EProduct> products = employeeDAO.getProducts();
		model.addAttribute("products", products);
		
		return "listProducts";
	}
	
	
}