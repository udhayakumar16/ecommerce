package com.ecommerce.entity.DAO;

import com.ecommerce.entity.Constants;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Constants.ORDER_TABLE_NAME)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDao {

    @Id
    @Column(name = Constants.ORDER_ID)
    private Long orderId;

    @Column(name = Constants.PRODUCT_ID)
    Long productId;

    @Column(name = Constants.QUANTITY)
    Long quantity;

    @Column(name = Constants.EMAIL_ID)
    String emailId;

    @Column(name = Constants.ADDRESS)
    String address;

    @Column(name = Constants.PHONE_NUMBER)
    String phoneNumber;

    @Column(name = Constants.PRODUCT_NAME)
    String productName;

    @Column(name = Constants.SELLING_PRICE)
    Double sellingPrice;


}
