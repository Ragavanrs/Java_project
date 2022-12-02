package com.example.TEST;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class TestappController {

	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product p1=new Product();
		p1.setId("1");
		p1.setName("Nirmal");
		
		productRepo.put(p1.getId(),p1);
	}
	@RequestMapping("/products")
	public ResponseEntity<Object> getProduct(){
		return new ResponseEntity<>(productRepo,HttpStatus.OK);
		}
	
	@RequestMapping(value="/prod",method = RequestMethod.POST)
	public ResponseEntity<Object> CreateProduct(@RequestBody Product p) 
	{
	
		productRepo.put(p.getId(),p);
		return new ResponseEntity<>("Created the product Successfuly",HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/products/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,@RequestBody Product product) throws ProductNotfoundException 
	{
		if(!productRepo.containsKey(id) )throw new ProductNotfoundException();
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id,product);
		return new ResponseEntity<>("Updated the product Successfuly",HttpStatus.OK);
		
		
	}
	@RequestMapping(value="/prod/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) 
	{
		productRepo.remove(id);
		
		return new ResponseEntity<>("Deleted the product Successfuly",HttpStatus.OK);
		
		
	}
	
	
}
