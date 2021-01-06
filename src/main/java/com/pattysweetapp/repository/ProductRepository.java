package com.pattysweetapp.repository;


import com.pattysweetapp.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    public List<Product> findProductByProdNameLike(String prodName);

	@Override
    void delete(Product deleted);
}
