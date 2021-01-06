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

    @RequestMapping(method= RequestMethod.POST, value="/findByLineID")
    public Customer findByLineID(@RequestBody Customer customer) {
        System.out.println("findByLineID lineID="+customer.getLineID());
        return customerRepository.findByLineID(customer.getLineID());
    }

    @RequestMapping(method= RequestMethod.POST, value="/findCustomerByLineID")
    public Customer findCustomerByLineID(@RequestBody String lineID) {
        System.out.println("findCustomerByLineID lineID="+lineID);
        return customerRepository.findByLineID(lineID);
    }

    @RequestMapping(method= RequestMethod.POST, value="/findByLineIDLike")
    public Customer findByLineIDLike(@RequestBody Customer customer) {
        System.out.println("findByLineIDLike lineID="+customer.getLineID());
        return customerRepository.findByLineIDLike(customer.getLineID());
    }

    @RequestMapping(method=RequestMethod.POST, value="/customer")
    public String save(@RequestBody Customer customer) {

        customer.setCreatedDate(DateTimeUtils.getSystemDate());
        customer.setUpdatedDate(DateTimeUtils.getSystemDate());
        customerRepository.save(customer);

        return "Customer saved id="+customer.getId()+" is Successes.";
    }


}
