package org.dsu.dc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.dsu.dc.domain.CartVO;
import org.dsu.dc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping("insert")
	public String insert(@ModelAttribute CartVO vo, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		
		int count = cartService.countCart(vo.getProductId(), userId);
		
		if(count ==0) {
			cartService.insert(vo);
		}else {
			cartService.updateCart(vo);
		}
		return "redirect:/board/list";
	}
	
	@RequestMapping("listCart")
	public ModelAndView listCart(HttpSession session, ModelAndView mav) {
		String userId = (String) session.getAttribute("userId");
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<CartVO> listCart = cartService.listCart(userId);
		int sumMoney = cartService.sumMoney(userId);
		int fee = sumMoney >= 100000 ? 0 : 2500;
		map.put("list", listCart);
		map.put("count", listCart.size());
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("allSum", sumMoney+fee);
		mav.setViewName("board/cartList");
		mav.addObject("map", map);
		
		return mav;
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam int cartId) {
		cartService.delete(cartId);
		return "redirect:/board/list";
	}
	
	@RequestMapping("update")
	public String update(@RequestParam int[] amount, @RequestParam int[] productId, HttpSession session) {
		String userId = (String) session.getAttribute("uesrId");
		for(int i=0; i<productId.length; i++) {
			CartVO vo = new CartVO();
			vo.setUserId(userId);
			vo.setAmount(amount[i]);
			vo.setProductId(productId[i]);
			cartService.modifyCart(vo);
		}
		
		return "redirect:/board/list";
	}
}
