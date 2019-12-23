package org.dsu.dc.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
	private long productId;
	private String productName;
	private long productPrice;
	private String productDesc;
	private String productUrl;
	private MultipartFile productPhoto;
}
