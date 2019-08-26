package com.test.service.impl;

import com.test.dao.ProduitDao;
import com.test.model.Produit;
import com.test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	
	@Autowired
	private ProduitDao produitDao;
	


	@Override
	public List<Produit> findAllProducts() {
		List<Produit> list = new ArrayList<>();
		produitDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	
	

}
