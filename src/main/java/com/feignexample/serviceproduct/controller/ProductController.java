package com.feignexample.serviceproduct.controller;

import com.feignexample.servicecommon.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public List<Product> listProducts(){
        return Datastore.listProducts();
    }
    @GetMapping("/{id}")
    private Product getProductById(@PathVariable String id){
        return Datastore.listProducts().stream().filter(prd ->
                prd.getId().equalsIgnoreCase(id)).findFirst().get();
    }
    @PostMapping
    private Product getProductById(@RequestBody Product product){
        product.setId("PRD " + RandomUtils.nextInt());
        return product;
    }
    @GetMapping("/customer/{custId}")
    public List<Product> listProductsByCustomerId(@PathVariable String
                                                          custId){
        return Datastore.listProducts().stream().filter(product ->
                        product.getCustomerid().equalsIgnoreCase(custId)).
                collect(Collectors.toList());
    }
}
