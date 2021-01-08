package com.pattysweetapp.controllers;

import com.pattysweetapp.models.Customer;
import com.pattysweetapp.repository.CustomerRepository;
import com.pattysweetapp.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(method= RequestMethod.GET, value="/customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @RequestMapping(method= RequestMethod.GET, value="/findCustomersByLineID")
    public List<Customer> findCustomersBy(String lineID) {
        return customerRepository.findCustomersBy(lineID);
    }

    @RequestMapping(method= RequestMethod.POST, value="/findByNickNameLike")
    public List<Customer> findByNickNameLike(@RequestBody Customer customer) {
        System.out.println("findByNickNameLike lineID="+customer.getNickName());
        return customerRepository.findByNickNameLike(customer.getNickName());
    }

    @RequestMapping(method=RequestMethod.POST, value="/customer")
    public String save(@RequestBody Customer customer) {

        customer.setCreatedDate(DateTimeUtils.getSystemDate());
        customer.setUpdatedDate(DateTimeUtils.getSystemDate());
        customerRepository.save(customer);
        return "Customer saved id="+customer.getNickName()+" is Successes.";
    }


}
