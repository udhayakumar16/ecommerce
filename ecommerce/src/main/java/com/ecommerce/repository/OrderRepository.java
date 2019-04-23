package com.ecommerce.repository;

import com.ecommerce.entity.DAO.OrderDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderDao, Long> {

    List<OrderDao> findByEmailId(String emailId);

}