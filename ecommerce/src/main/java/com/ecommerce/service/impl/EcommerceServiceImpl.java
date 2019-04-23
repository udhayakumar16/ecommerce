package com.ecommerce.service.impl;

import com.ecommerce.entity.DAO.OrderDao;
import com.ecommerce.entity.DAO.ProductDao;
import com.ecommerce.entity.DTO.OrderDto;
import com.ecommerce.entity.DTO.ProductDto;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.EcommerceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EcommerceServiceImpl implements EcommerceService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orderDtoList = new ArrayList <>();
        Iterable orderDaoIterable = orderRepository.findAll();
        OrderDto orderDto = new OrderDto();
            orderDaoIterable.forEach(
                order -> {
                    BeanUtils.copyProperties(order, orderDto);
                    orderDtoList.add(orderDto);
                }
            );
        return orderDtoList;
    }

    @Override
    public List <ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = new ArrayList <>();
        Iterable productDaoIterable = productRepository.findAll();
        ProductDto productDto = new ProductDto();
        productDaoIterable.forEach(
                order -> {
                    BeanUtils.copyProperties(order, productDto);
                    productDtoList.add(productDto);
                }
        );
        return productDtoList;
    }

    @Override
    public String addProduct(ProductDto productDto) {
        if(productDto != null) {
            ProductDao productDao = new ProductDao();
            BeanUtils.copyProperties(productDto, productDao);
            productDao = productRepository.save(productDao);
            if (productDao != null) {
                return "SUCCESS";
            }
        }
        return "FAILURE";
    }

    @Override
    public String placeOrder(OrderDto orderDto) {
        Long stock = productRepository.findStockById(orderDto.getProductId());
        if(orderDto != null) {
            if (orderDto.getQuantity() > stock) {
                return "Only " + stock + " are available in stock";
            } else {
                OrderDao orderDao = new OrderDao();
                BeanUtils.copyProperties(orderDto, orderDao);
                orderDao = orderRepository.save(orderDao);
                if(orderDao != null) {
                    ProductDao productDao = productRepository.findById(orderDto.getProductId()).get();
                    productDao.setStock(productDao.getStock() - orderDto.getQuantity());
                    productDao = productRepository.save(productDao);
                    if(productDao == null) {
                        orderRepository.deleteById(orderDao.getOrderId());
                        return "Error occurred while placing order!!!  Try again later!!!";
                    }
                }
                else {
                    return "Error occurred while placing order!!!  Try again later!!!";
                }
            }
        }
        return "Order placed Successfully";
    }

    @Override
    public List<OrderDto> viewOrderDetails(String emailId) {
        OrderDto orderDto = null;
        List<OrderDto> orderDtoList = new ArrayList <>();
        List<OrderDao> orderDaoList = orderRepository.findByEmailId(emailId);
        if(orderDaoList != null && orderDaoList.size() != 0) {
            for(OrderDao orderDao : orderDaoList) {
                orderDto = new OrderDto();
                BeanUtils.copyProperties(orderDao, orderDto);
                orderDtoList.add(orderDto);
            }
        }
        return orderDtoList;
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductDto productDto = null;
        ProductDao productDao = productRepository.findById(id).get();
        if(productDao != null) {
            productDto = new ProductDto();
            BeanUtils.copyProperties(productDao, productDto);
        }
        return productDto;
    }

    @Override
    public ProductDto updateProductDetails(ProductDto productDto) {
        if(productDto != null && productRepository.existsById(productDto.getId())) {
            ProductDao productDao = new ProductDao();
            BeanUtils.copyProperties(productDto, productDao);
            productDao = productRepository.save(productDao);
            BeanUtils.copyProperties(productDao, productDto);
        }
        return productDto;
    }

    @Override
    public String deleteProduct(Long id) {
        if(id != null) {
            productRepository.deleteById(id);
            ProductDao productDao = productRepository.findById(id).get();
            if (productDao != null)
                return "Product removed successfully";
        }
        return "Try again later!!!";
    }

    @Override
    public String deleteOrder(Long id) {
        if(id != null) {
            orderRepository.deleteById(id);
            OrderDao orderDao = orderRepository.findById(id).get();
            if (orderDao == null) {
                return "Order Cancelled!!!";
            }
        }
        return "Try Again later!!!";
    }
}
