package com.pattysweetapp.controllers;

import com.pattysweetapp.models.Product;
import com.pattysweetapp.repository.ProductRepository;
import com.pattysweetapp.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    ProductRepository productRepository;

    @RequestMapping(method=RequestMethod.GET, value="/products")
    public List<Product> product() {
        return productRepository.findAll();
    }


    @RequestMapping(method= RequestMethod.POST, value="/findProductByProdNameLike")
    public List<Product> findProductByProdNameLike(@RequestBody Product product) {
        System.out.println("findProductByProdNameLike prodName="+product.getProdName());

        return  productRepository.findProductByProdNameLike(product.getProdName());
    }
    @RequestMapping(method=RequestMethod.POST, value="/product")
    public String save(@RequestBody Product product) {

        product.setCreatedDate(DateTimeUtils.getSystemDate());
        product.setUpdatedDate(DateTimeUtils.getSystemDate());
        productRepository.save(product);

        return product.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/product/{id}")
    public Optional<Product> show(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/product/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
    	Optional<Product> prod = productRepository.findById(id);
        if(product.getProdName() != null)
            prod.get().setProdName(product.getProdName());
        if(product.getProdDesc() != null)
            prod.get().setProdDesc(product.getProdDesc());
        if(product.getProdPrice() != null)
            prod.get().setProdPrice(product.getProdPrice());
        if(product.getProdImage() != null)
            prod.get().setProdImage(product.getProdImage());
        productRepository.save(prod.get());
        return prod.get();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/product/{id}")
    public String delete(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
        return "product deleted id="+id;
    }
}
