package com.codemobiles.stock_java_backend.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codemobiles.stock_java_backend.controller.request.ProductRequest;
import com.codemobiles.stock_java_backend.exception.ProductNotFoundException;
import com.codemobiles.stock_java_backend.model.Product;
import com.codemobiles.stock_java_backend.service.StorageService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final AtomicLong counter = new AtomicLong();
	private List<Product> products = new ArrayList<>();
	
	private StorageService storageService;
	
	ProductController(StorageService storageService){
		this.storageService = storageService;
	}

	// request -> path -> process -> response
	// POST MAN : http://localhost:1150/getProducts
	@GetMapping()
	public List<Product> getProducts() {
		return products;
	}

	// POST MAN : http://localhost:1150/getProduct/1
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id) {
		return products.stream().filter(result -> result.getId() == id).findFirst()
				.orElseThrow(() -> new ProductNotFoundException(id));
	}

	// POST MAN : http://localhost:1150/getProduct/id/1/name/test
//	@GetMapping("/id/{id}/name/{name}")
//	public String getProductByIdAndName(@PathVariable long id,  @PathVariable String name) {
//		return "Get Product By ID : " + id + " Name : " + name;
//	}

	// POST MAN : http://localhost:1150/getProduct/id/1
	@GetMapping({ "/id/{id}/name/{name}", "/getProduct/id/{id}" })
	public String getProductByIdAndName(@PathVariable(value = "id") long id,
			@PathVariable(required = false) String name) {
		return "Get Product By ID : " + id + " Name : " + name;
	}

//	//POST MAN : http://localhost:1150/getProduct/name?name=natdanai
//	@GetMapping({"/getProduct/name"})
//	public String getProductByNameQuery(@RequestParam("name") String name) {
//		return "Get Product By Name : " + name;
//	}

	// POST MAN : http://localhost:1150/getProduct/name?name
	@GetMapping({ "/name" })
	public String getProductByNameQuery(
			@RequestParam(name = "name", required = false, defaultValue = "cat") String name) {
		return "Get Product By Name : " + name;
	}

	// POST MAN : curl --location --request POST 'http://localhost:1150/product' \
	// --header 'Content-Type: application/json' \
	// --data-raw '{
	// "id" : 1,
	// "name" : "pen",
	// "image" : "pen.jpg",
	// "price" : 10,
	// "stock" : 5
	// }'
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public Product addProduct(ProductRequest productRequest) {
		String fileName = storageService.store(productRequest.getImage());
		Product data = new Product(
				counter.incrementAndGet(), 
				productRequest.getName(), 
				fileName, 
				productRequest.getPrice(),
				productRequest.getStock());
		products.add(data);
		return data;
	}

	// POST MAN : curl --location --request PUT 'http://localhost:1150/product/1' \
	// --header 'Content-Type: application/json' \
	// --data-raw '{
	// "name" : "fish",
	// "image" : "fish.jpg",
	// "price" : 99,
	// "stock" : 88
	// }'
	@PutMapping("/{id}")
	public void editProduct(@RequestBody Product product, @PathVariable Long id) {
		products.stream().filter(result -> result.getId() == id).findFirst().ifPresentOrElse(result -> {
			result.setName(product.getName());
			result.setImage(product.getImage());
			result.setPrice(product.getPrice());
			result.setStock(product.getStock());
		}, () -> {
			throw new ProductNotFoundException(id);
		});
	}

	// POST MAN : curl --location --request DELETE 'http://localhost:1150/product/3'
	// \
	// --data-raw ''
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		products.stream().filter(result -> result.getId() == id).findFirst()
				.ifPresentOrElse(result -> products.remove(result), () -> {
					throw new ProductNotFoundException(id);
				});
	}
	
	
}
