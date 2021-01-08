package com.pattysweetapp.repository;

import com.pattysweetapp.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository  extends MongoRepository<Customer,String> {
    public List<Customer> findCustomersBy(String lineID);

    /**
     *
     * @param nickName
     * @return
     */
    public List<Customer>findByNickNameLike(String nickName);




}
