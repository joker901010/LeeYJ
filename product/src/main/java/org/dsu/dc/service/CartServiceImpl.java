package org.dsu.dc.service;

import java.util.List;

import org.dsu.dc.domain.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDAO cartDao;
	
	@Override
	public void insert(CartVO vo) {
		cartDao.insert(vo);

	}

	@Override
	public List<CartVO> listCart(String userId) {
		return cartDao.listCart(userId);
	}

	@Override
	public void delete(int cartId) {
		cartDao.delete(cartId);
	}

	@Override
	public void modifyCart(CartVO vo) {
		cartDao.modifyCart(vo);
	}

	@Override
	public int sumMoney(String userId) {
		return cartDao.sumMoney(userId);
	}

	@Override
	public int countCart(int productId, String userId) {
		return cartDao.countCart(productId, userId);
	}

	@Override
	public void updateCart(CartVO vo) {
		cartDao.updateCart(vo);
	}

}
