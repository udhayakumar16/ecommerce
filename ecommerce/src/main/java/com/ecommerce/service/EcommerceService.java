package com.ecommerce.service;

import com.ecommerce.entity.DTO.OrderDto;
import com.ecommerce.entity.DTO.ProductDto;

import java.util.List;

public interface EcommerceService {

    List<OrderDto> getAllOrders();

    List<ProductDto> getAllProducts();

    String addProduct(ProductDto productDto);

    String placeOrder(OrderDto orderDto);

    List<OrderDto> viewOrderDetails(String emailId);

    ProductDto getProductById(Long id);

    ProductDto updateProductDetails(ProductDto productDto);

    String deleteProduct(Long id);

    String deleteOrder(Long id);

}