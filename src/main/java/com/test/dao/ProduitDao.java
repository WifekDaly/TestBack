package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Produit;



@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer> {
   
	
}
