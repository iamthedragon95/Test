package com.niit.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.test.model.Cart;
import com.niit.test.model.Product;
import com.niit.test.service.Cartservice;
import com.niit.test.service.ProductService;
@Controller
public class CartController {
	@Autowired
	Cartservice cs;
	
	@Autowired
	ProductService ps;
	
	@RequestMapping(value ="/addtocart/{id}")
	public String add(@PathVariable("id") String id) {
		Cart cart=new Cart();
		Product pm=ps.getProductModel(id);
		List<Cart> allCart = (List<Cart>) cs.getAllCart();
		List<Cart> p = allCart;
		for(int i=0;i<p.size();i++)
		{
			
			String pid=p.get(i).getProduct().getId();
			System.out.println(pid);
			System.out.println(id);
			if(pid.equals(id))
			{	System.out.println("Existing avaiable loop");
					int quan=p.get(i).getQuantity()+1;
				p.get(i).setQuantity(quan);
				p.get(i).setTotalprice(p.get(i).getProduct().getPrice()*quan);;
				System.out.println("update");
				cs.update(p.get(i));
				return "redirect:/viewcart";
			}
		}
		System.out.println("newproduct");
		
		cart.setQuantity(1);
		cart.setTotalprice(pm.getPrice());
		cart.setProduct(pm);
		cs.add(cart);
		return "redirect:/viewcart";
	}

	@RequestMapping(value = "/viewcart")
	public String cart(Map<String, Object> map, Cart cart) {

		map.put("cart", cart);
		map.put("cartlist", cs.getAllCart());

		return "Cart";
	}
	@RequestMapping(value="/deleted/cartitem/{cid}")
	public String deleteaction(@PathVariable("cid") int cid)
	{
		cs.deletecartitem(cid);
		return "redirect:/viewcart";
	}


}
