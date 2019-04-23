package com.ecommerce.entity.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long orderId;

    private Long productId;

    private Long quantity;

    private String emailId;

    private String address;

    private String phoneNumber;

    private String productName;

    private Double sellingPrice;

}
