package com.royal.shopcart.data;

import com.royal.shopcart.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
