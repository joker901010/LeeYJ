package org.dsu.dc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dsu.dc.domain.CartVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CartMapper {
	List<CartVO> listCart();
	
	int sumMoney();
	
	void modifyCart();
	void deleteCart();
	int countCart();
	void updateCart();
}
