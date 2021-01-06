package com.pattysweetapp.repository;

import com.pattysweetapp.models.TrackingPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackingPriceRepository extends MongoRepository <TrackingPrice, String> {


@Query("{'Product.id':?0}")
public List<TrackingPrice> findByProductId(String id);


}
