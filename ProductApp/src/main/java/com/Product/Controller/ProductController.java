package com.Product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Product.Entity.Product;
import com.Product.Service.ProductService;

@RestController
@RequestMapping("/productapp")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
	Product p=productService.addProduct(product);
		return ResponseEntity.ok(p);
	}
	
	
	@GetMapping("/findall")
	public ResponseEntity<List<Product>> findAllProduct()
	{
		List<Product> products=productService.findAllProduct();
		
		return ResponseEntity.ok(products);
	}
	

}
