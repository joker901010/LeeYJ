package org.dsu.dc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dsu.dc.domain.CartVO;
import org.dsu.dc.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartDAOImpl implements CartDAO {
	@Autowired
	private CartMapper mapper;
	
	@Override
	public void insert(CartVO vo) {
		log.info("[Cart Insert...] {}", vo);
		mapper.listCart();
	}

	@Override
	public List<CartVO> listCart(String userId) {
		log.info("[Cart List...] {}", userId);
		return mapper.listCart();
	}

	@Override
	public void delete(int cartId) {
		log.info("[Cart Delete...] {}", cartId);
		mapper.deleteCart();
	}

	@Override
	public void modifyCart(CartVO vo) {
		log.info("[Cart Update...] {}", vo);
		mapper.updateCart();
	}

	@Override
	public int sumMoney(String userId) {
		log.info("[Cart SumMoney...] {}", userId);
		return mapper.sumMoney();
	}

	@Override
	public int countCart(int productId, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productId", productId);
		map.put("userId", userId);
		return mapper.countCart();
	}

	@Override
	public void updateCart(CartVO vo) {
		log.info("[Cart SumCart...] {}", vo);
		mapper.updateCart();

	}

}
