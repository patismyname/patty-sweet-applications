package com.pattysweetapp.controllers;

import com.pattysweetapp.models.Product;
import com.pattysweetapp.models.TrackingPrice;
import com.pattysweetapp.repository.TrackingPriceRepository;
import com.pattysweetapp.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TrackingPriceController {
    @Autowired
    TrackingPriceRepository trackingPriceRepository;


    @RequestMapping(method= RequestMethod.GET, value="/trackingprices")
    public List<TrackingPrice> findAll() {
        return trackingPriceRepository.findAll();
    }//


    @RequestMapping(method=RequestMethod.POST, value="/trackingprice")
    public String save(@RequestBody TrackingPrice trackingPrice) {

        trackingPrice.setCreatedDate(DateTimeUtils.getSystemDate());
        trackingPrice.setUpdatedDate(DateTimeUtils.getSystemDate());
        trackingPriceRepository.save(trackingPrice);

        return "Created Success="+trackingPrice.getId();
    }

}
