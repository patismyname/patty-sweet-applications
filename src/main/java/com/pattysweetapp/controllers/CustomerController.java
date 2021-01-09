package com.pattysweetapp.controllers;

import com.pattysweetapp.models.Customer;
import com.pattysweetapp.models.TrackingPrice;
import com.pattysweetapp.repository.CustomerRepository;
import com.pattysweetapp.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
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

    @RequestMapping(method=RequestMethod.GET, value="/customer/{id}")
    public Optional<Customer> show(@PathVariable String id) {
        return customerRepository.findById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }


}
