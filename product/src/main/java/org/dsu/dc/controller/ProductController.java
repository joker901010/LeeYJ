package org.dsu.dc.controller;


import org.dsu.dc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/list");
		mav.addObject("list", productService.listProduct());
		return mav;
	}
	
	@RequestMapping("/detail/{productId}")
	public ModelAndView detail(@PathVariable("productId") int productId, ModelAndView mav) {
		mav.setViewName("/detail");
		mav.addObject("vo", productService.detailProduct(productId));
		return mav;
	}
}
