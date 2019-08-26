
package com.test.controller;
import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.dao.ProduitDao;
import com.test.model.ApiResponse;
import com.test.model.Produit;
import com.test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TestRestAPIs {
	
	
	@Autowired
	private ProduitDao produitDao;
	
	
    @Autowired
    private UserService userService;

  
    @PostMapping("/produits")
    public ApiResponse<Produit> ajouterProduit(@RequestParam(name="photo", required=false) MultipartFile photo, @RequestParam("description") String description,@RequestParam("prix") int prix) throws JsonParseException, JsonMappingException, IOException{
    	Produit produit = new Produit();
    	if(photo!= null) {
    	produit.setPhoto(photo.getBytes());
    	}
    	produit.setDescription(description);
    	produit.setPrix(prix);
    	return new ApiResponse<>(HttpStatus.OK.value(), "produit ajouté avec succés.",produitDao.save(produit));
    }
   
    
    @GetMapping("/products")
    public ApiResponse<List<Produit>> listProduits(){
        return new ApiResponse<>(HttpStatus.OK.value(), "produits retournés avec succés.",userService.findAllProducts());
    }
    
    
}