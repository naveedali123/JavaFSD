package com.company.sportyshoes.controller;

import java.util.List;
   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.sportyshoes.dao.SportyShoesDAO;
import com.company.sportyshoes.entity.Product;
import com.company.sportyshoes.entity.PurchaseReport;
import com.company.sportyshoes.entity.User;

@Controller
public class SportyShoesController {
	
		@Autowired
		SportyShoesDAO sportyShoesDAO;
		
		@PostMapping("/adminLogin")
		public String getUser(Model model, @RequestParam("adminemail") String adminemail, @RequestParam("adminpassword") String adminpassword) {
			
			String view = null;
			
			if(adminemail != null || adminpassword != null) {
				
				
			 	boolean isSuccess =  sportyShoesDAO.getAdmin(adminemail, adminpassword);
			 	
			 	if(isSuccess == true) {
		
			 		view = "adminDashboard";
			 		
			 	}else {
			 		
					view = "error";
				}
			}else {
				view = "error";
			}
			
			return view;
		}
		
//		@PostMapping("/adminLogin")
//		public String getUser(Model model, @RequestParam("adminemail") String adminemail, @RequestParam("adminpassword") String adminpassword) {
//			
//			String view = null;
//			
//			if(adminemail == null || adminemail.isBlank() || adminemail.isEmpty() || adminemail == "" || adminpassword == null || adminpassword.isEmpty() || adminpassword.isBlank() || adminpassword == "") {
//				
//				view = "errorLogin";
//				
//			}else {
//				
//				Admin admin = new Admin();
//				
//				admin.setAdminemail(adminemail);
//				admin.setAdminpassword(adminpassword);
//				
//			 	boolean isSuccess =  sportyShoesDAO.getAdmin(admin);
//			 	
//			 	if(isSuccess == true) {
//		
//			 		view = "adminDashboard";
//			 		
//			 	}else {
//			 		
//					view = "errorLogin";
//				}
//				
//			}
//			
//			return view;
//		}
		
		
		@PostMapping("/changePassword")
		public String adminCP(Model model, @RequestParam("adminpassword") String adminpassword) {
			
			String view = null;
			
			if(adminpassword == null || adminpassword.isEmpty()) {
			 	
			 	view = "errorCP";
			 	
			}else {
				
				sportyShoesDAO.changeAdminPassword(adminpassword);
			 	
			 	view = "succesfullCP";
				
			}
			
			return view;
		}
		
		
		@GetMapping("/listUser")
		public String seeUserList(Model model) {
			
			String view = null;
			
			List<User> userList = sportyShoesDAO.getUsers();
			
			if(userList == null || userList.isEmpty()) {
				
				view = "errorCP";
				
			}else {
				
				model.addAttribute("userList", userList);
				
				view = "listUser";
				
			}
			
			return view;
		}
		
		
		@PostMapping("/findUser")
		public String seeUserByName(Model model,  @RequestParam("username") String username ) {
			
			String view = null;
			
			if(username == null || username.isEmpty()) {
				
				view = "errorCP";
				
			}else {
			
				User user = sportyShoesDAO.getUserByName(username);
				
				if(user == null) {
					
					view = "errorCP";
					
				}else {
					
					model.addAttribute("user", user);
					
					view = "specificUserDetail";
					
				}
			
		   }
			
			return view;
		}
		
		
		@GetMapping("/productList")
		public String seeProductList(Model model) {
			
			String view = null;
			
			List<Product> productList = sportyShoesDAO.getProducts();
			
			if(productList == null || productList.isEmpty()) {
				
				view = "errorCP";
				
			}else {
				
				model.addAttribute("productList", productList);
				
				view = "listProducts";
				
			}
			
			return view;
		}
		
		
		@PostMapping("/addNewProduct")
		public String addProduct(Model model,  @RequestParam("productname") String productname, @RequestParam("productprice") String productprice, @RequestParam("category") String category) {
			
			String view = null;
			
			if(productname == null  || productname.isEmpty() || productprice == null   || productprice.isEmpty()) {
				
				view = "errorCP";
				
			}else {
				
				Product product = new Product();
				
				int price = Integer.parseInt(productprice);	
				
				product.setProductname(productname);
				product.setProductprice(price);
				product.setCategoryname(category);
				
				sportyShoesDAO.addProductDetail(product);
				
				view = "SuccesfullMessagePage";
			
		   }
			
			return view;
		}
		
		
		@PostMapping("/modifyProduct")
		public String modifyProduct(Model model,  @RequestParam("productid") String productid, @RequestParam("productprice") String productprice, @RequestParam("category") String category) {
			
			String view = null;
			
			if(productid == null || productid.isEmpty() || productprice == null   || productprice.isEmpty()) {
				
				view = "errorCP";
				
			}else {
				
				Product product = new Product();
				
				int id = Integer.parseInt(productid);
				int price = Integer.parseInt(productprice);	
				
				product.setProductid(id);
				product.setProductprice(price);
				product.setCategoryname(category);
				
				sportyShoesDAO.modifyProductDetail(product);
				
				view = "SuccesfullMessagePage";
			
		   }
			
			return view;
		}
		
		
		@PostMapping("/deleteProductDetail")
		public String deleteProductDetail(Model model,  @RequestParam("productid") String productid) {
			
			String view = null;
			
			if(productid == null || productid.isEmpty() || productid == "") {
				
				view = "errorCP";
				
			}else {
				
				int id = Integer.parseInt(productid);
				
				int successVal= sportyShoesDAO.deletProductById(id);
				
				if(successVal == 0) {
					
					view = "errorCP";
					
				}else {
				
					view = "SuccesfullMessagePage";
				}
			}
			
			return view;
			
		}
		
		
		@PostMapping("/purchaseReport")
		public String purchaseReport(Model model,  @RequestParam("category") String category, @RequestParam("purchasedate") String purchasedate) {
			
			String view = null;
			
			if(purchasedate == null) {
				
				view = "errorCP";
				
			}else {
				
			   int categoryid = Integer.parseInt(category);
				
			   List<PurchaseReport>  purchaseReportrs =  sportyShoesDAO.getPurchaseReport(categoryid, purchasedate);
			   
			   if (purchaseReportrs == null || purchaseReportrs.isEmpty()) {
				
				   view = "errorCP";
			   }else {
				
				   model.addAttribute("purchaseReportrs", purchaseReportrs);
				   view = "purchaseList";
			   }
				
			}
			
			return view;
			
		}
}
