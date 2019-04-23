package com.ecommerce.controller;

import com.ecommerce.entity.DTO.OrderDto;
import com.ecommerce.entity.DTO.ProductDto;
import com.ecommerce.service.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ecommerce.entity.Constants.BASE_PATH;

@RestController
@RequestMapping(value = BASE_PATH)
public class ecommerceController {

    @Autowired
    private EcommerceService ecommerceService;

    @RequestMapping(method = RequestMethod.GET, value = "/get-all-orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDTOList = ecommerceService.getAllOrders();
        return new ResponseEntity<>(orderDTOList,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-all-products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = ecommerceService.getAllProducts();
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-all-orders")
    public ResponseEntity<List<OrderDto>> viewOrderDetails(@RequestParam("emailId") String emailId) {
        List<OrderDto> orderDtoList = ecommerceService.viewOrderDetails(emailId);
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-product")
    public ResponseEntity<ProductDto> getPrdouctDetailsById(@RequestParam("id") Long id) {
        ProductDto productDto = ecommerceService.getProductById(id);
        return new ResponseEntity(productDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cancel-order")
    public ResponseEntity<String> cancelOrder(@RequestParam("id") Long id) {
        String response = ecommerceService.deleteOrder(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/remove-product")
    public ResponseEntity<String> removeProduct(@RequestParam("id") Long id) {
        String response = ecommerceService.deleteProduct(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        String response = ecommerceService.addProduct(productDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        ProductDto productDetails = ecommerceService.updateProductDetails(productDto);
        return new ResponseEntity(productDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/place-order")
    public ResponseEntity<ProductDto> placeOrder(@RequestBody OrderDto orderDto) {
        String response = ecommerceService.placeOrder(orderDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
