package org.dsu.dc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dsu.dc.domain.ProductVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper {
	List<ProductVO> listProduct();
	
	ProductVO deatilProduct();
}
