package org.dsu.dc.domain;

import lombok.Data;

@Data
public class CartVO {
	private int cartId;
	private String userId;
	private String userName;
	private int productId;
	private String productName;
	private int productPrice;
	private int amount;
	private int money;
}
