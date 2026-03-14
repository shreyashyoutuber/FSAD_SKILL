package com.klu.controller;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    // Insert sample data
    @PostMapping("/add")
    public String addProducts(){

        repo.save(new Product("Laptop","Electronics",60000));
        repo.save(new Product("Phone","Electronics",30000));
        repo.save(new Product("Shoes","Fashion",5000));
        repo.save(new Product("Watch","Fashion",8000));
        repo.save(new Product("Tablet","Electronics",25000));

        return "Products added";
    }

    // Search by category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){

        return repo.findByCategory(category);
    }

    // Filter price range
    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min,@RequestParam double max){

        return repo.findByPriceBetween(min,max);
    }

    // Sort by price
    @GetMapping("/sorted")
    public List<Product> sortedProducts(){

        return repo.findSortedByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price){

        return repo.findExpensiveProducts(price);
    }
}