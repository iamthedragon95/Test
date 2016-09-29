package com.niit.test.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.test.model.Cart;
import com.niit.test.model.Shipping;

@Repository
@Transactional
public class CartDaoImpl implements Cartdao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public void add(Cart cart) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(cart);
		
	}

	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from CART ").list();

	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(cart);
		
	}
	public Cart getCartdetbycid(int cid)
	{
		return (Cart)sf.getCurrentSession().get(Cart.class,cid);
		
	}
	
	@Override
	public void deletecartitem(int cid) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(getCartdetbycid(cid));
	}

	@Override
	public void saveshippment(Shipping shippingdetails) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().saveOrUpdate(shippingdetails);
	}
}
