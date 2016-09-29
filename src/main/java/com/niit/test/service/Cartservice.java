package com.niit.test.service;

import java.util.List;

import com.niit.test.model.Cart;
import com.niit.test.model.Shipping;

public interface Cartservice {
	void add(Cart cart);

	public List<Cart> getAllCart();
	void update(Cart cart);
	void deletecartitem(int cid);

	void saveshipment(Shipping shippingdetails);

}
