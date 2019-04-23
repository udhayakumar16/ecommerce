package com.ecommerce.entity.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String productName;

    private String description;

    private Long stock;

    private Double sellingPrice;

    private String MerchantName; //can be enhanced

    private Boolean offerAvailability;

    private Double discountPercentage;

    private String colour;

    private String brand;

    private String model;

}