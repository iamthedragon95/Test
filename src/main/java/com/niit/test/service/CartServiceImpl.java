package com.niit.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.test.dao.Cartdao;
import com.niit.test.model.Cart;
import com.niit.test.model.Shipping;

@Service
@Transactional
public class CartServiceImpl implements Cartservice {
	@Autowired
	Cartdao cd;
	


	@Override
	public void add(Cart cart) {
		// TODO Auto-generated method stub
		cd.add(cart);
		
	}

	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return cd.getAllCart();
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		cd.update(cart);
		
	}
	@Override
	public void deletecartitem(int cid) {
		// TODO Auto-generated method stub
	cd.deletecartitem(cid);	
	}

	@Override
	public void saveshipment(Shipping shippingdetails) {
		// TODO Auto-generated method stub
		cd.saveshippment(shippingdetails);
	}
}
