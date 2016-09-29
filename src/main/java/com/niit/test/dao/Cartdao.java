package com.niit.test.dao;

import java.util.List;

import com.niit.test.model.Cart;
import com.niit.test.model.Shipping;

public interface Cartdao {

	void add(Cart cart);

	List<Cart> getAllCart();

	void update(Cart cart);
	void deletecartitem(int cid);

	void saveshippment(Shipping shippingdetails);

}
