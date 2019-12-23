package org.dsu.dc.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.dsu.dc.domain.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ProductVO> listProduct(){
		return sqlSession.selectList("product.listProduct");
	}

	@Override
	public ProductVO detailProduct(int productId) {
		return sqlSession.selectOne("product.detailProduct", productId);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

}
