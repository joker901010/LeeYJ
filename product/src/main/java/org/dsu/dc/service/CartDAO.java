package org.dsu.dc.service;

import java.util.List;

import org.dsu.dc.domain.CartVO;

public interface CartDAO {
	void insert(CartVO vo);
	List<CartVO> listCart(String userId);
	void delete(int cartId);
	void modifyCart(CartVO vo);
	int sumMoney(String userId);
	int countCart(int productId, String userId);
	void updateCart(CartVO vo);
}
