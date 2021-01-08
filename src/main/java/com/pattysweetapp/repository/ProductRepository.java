package com.pattysweetapp.repository;

import com.pattysweetapp.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    public List<Product> findProductByProdNameLike(String prodName);

	@Override
    void delete(Product deleted);
}
