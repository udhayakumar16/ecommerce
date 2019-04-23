package com.ecommerce.repository;

import com.ecommerce.entity.DAO.ProductDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductDao, Long> {

    Long findStockById(long id);
}
