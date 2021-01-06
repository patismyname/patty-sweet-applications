package com.pattysweetapp.repository;

import com.pattysweetapp.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository  extends MongoRepository<Customer,String> {
    public List<Customer> findCustomersBy(String lineID);

    public  Customer findByLineID(String lineID);

    public Customer findByLineIDLike(String lineID);

}
