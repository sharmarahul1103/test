package com.Product.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Product.Entity.Product;
import com.Product.Repo.ProductRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepo productRepo;
	
	
	public Product addProduct(Product product)
	{
	    return	productRepo.save(product);
	}
	
	
	public List<Product> findAllProduct()
	{
	        return 	productRepo.findAll();
	}
	
}
