package com.whiskeyworldwide.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<com.whiskeyworldwide.model.Products, Long> {

}

