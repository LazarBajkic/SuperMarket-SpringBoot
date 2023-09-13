package com.bajkic.market.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bajkic.market.model.CartProduct;
import com.bajkic.market.model.Product;
import com.bajkic.market.model.UserInfo;
import com.bajkic.market.repository.CartRepository;
import com.bajkic.market.repository.MarketRepository;

import jakarta.validation.Valid;

@Controller
public class MarketController {
	
	@Autowired
	private MarketRepository mRep;
	
	@Autowired
	private CartRepository cRep;
	
	//Methods used to get each section
	
	@GetMapping("/getMeatSection")
	public ModelAndView getMeatProducts() {
		ModelAndView mav = new ModelAndView("MeatProducts");
		List<Product> product = mRep.findProductTypes("Meat");
		mav.addObject("products",product);
		return mav;
	}
	
	@GetMapping("/getDairySection")
	public ModelAndView getDairyProducts() {
		ModelAndView mav = new ModelAndView("DairyProducts");
		List<Product> product = mRep.findProductTypes("Dairy");
		mav.addObject("products", product);
		return mav;
	}
	
	@GetMapping("/getBakerySection")
	public ModelAndView getBakeryProducts() {
		ModelAndView mav = new ModelAndView("BakeryProducts");
		List<Product> product = mRep.findProductTypes("Bakery");
		mav.addObject("products", product);
		return mav;
	}
	
	@GetMapping("/getFruitSection")
	public ModelAndView getFruitProducts() {
		ModelAndView mav = new ModelAndView("FruitProducts");
		List<Product> product = mRep.findProductTypes("Fruit");
		mav.addObject("products",product);
		return mav;
	}
	
	@GetMapping("/getVegetableSection")
	public ModelAndView getVegetableProducts() {
		ModelAndView mav = new ModelAndView("VegetableProducts");
		List<Product> product = mRep.findProductTypes("Vegetable");
		mav.addObject("products", product);
		return mav;
	}
	
	//This method adds the desired product to the cart
	
	@PostMapping("/addToCart")
	public String addToCart(@Valid @ModelAttribute("product") Product product,BindingResult bindingResult,@RequestParam Integer id) {
		
		if(bindingResult.hasErrors()) {
			return bindingResult.getAllErrors().toString();
		}else {
			CartProduct cp = new CartProduct(product.getId(),product.getProductName(),product.getQuantity(),product.getPrice(),product.getDesiredAmount());
			cRep.save(cp);
			return "redirect:/checkDetails?id="+cp.getId();	
		}
	}
	
	//this method gets the home page
	
	@GetMapping("/getHomePage")
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	//this method shows the cart
	
	@GetMapping("/showCart")
	public ModelAndView showCart() {
		ModelAndView mav = new ModelAndView("Cart");
		List<CartProduct> cartProducts = cRep.findAll();
		mav.addObject("cartProducts",cartProducts);
		return mav;
	}
	
	//this method is used to get the page where the user enter his information
	
	@GetMapping("/finishOrder")
	public String finishOrdering(UserInfo userInfo) {
		return "EnterCardInfo";
	}
	
	//this method gets the specified products information page
	
	@GetMapping("/checkDetails")
	public ModelAndView checkDetails(@RequestParam Integer id,Model model) {
		ModelAndView mav = new ModelAndView("ProductInfo");
		Product product = mRep.findById(id).get();
		model.addAttribute("product",product);
		mav.addObject("specificProduct",product);
		return mav;
	}
	
	//this method checks the users credentials 
	
	@PostMapping("/checkCredentials")
	public String checkCreds(@Valid UserInfo userInfo,BindingResult bindingResult,RedirectAttributes redirAttrs) {
		
		if(bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("error", "Invalid credit card number");
			return "redirect:/finishOrder";
		}else {
			redirAttrs.addFlashAttribute("success", "Your order was recorded! ,you can now go back to the home page or exit");
			cRep.deleteAll();
			return "redirect:/finishOrder";
		}
		
	}
	
	//binding
	
	@GetMapping("/showDetails")
    public String showForm(Model model) {
        Product p = new Product();
        model.addAttribute("product", p);
        return "ProductInfo"; 
    }

}
