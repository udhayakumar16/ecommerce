package com.ecommerce.entity.DAO;

import com.ecommerce.entity.Constants;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.ecommerce.entity.Constants.*;

@Entity
@Table(name = Constants.PRODUCT_TABLE_NAME)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDao {

    @Id
    @Column(name = PRODUCT_ID)
    Long id;

    @Column(name = PRODUCT_NAME)
    String productName;

    @Column(name = DESCRIPTION)
    String description;

    @Column(name = STOCK)
    Long stock;

    @Column(name = SELLING_PRICE)
    Double sellingPrice;

    @Column(name = MERCHANT_NAME)
    String MerchantName; //can be enhanced

    @Column(name = OFFER_AVAILABILITY)
    Boolean offerAvailability;

    @Column(name = DISCOUNT_PERCENTAGE)
    Double discountPercentage;

    @Column(name = COLOUR)
    String colour;

    @Column(name = BRAND)
    String brand;

}
