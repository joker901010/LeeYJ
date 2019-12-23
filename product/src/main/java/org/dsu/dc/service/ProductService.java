package org.dsu.dc.service;

import java.util.List;

import org.dsu.dc.domain.ProductVO;

public interface ProductService {
	List<ProductVO> listProduct();
	ProductVO detailProduct(int productId);
	void updateProduct(ProductVO vo);
	void deleteProduct(int productId);
}
