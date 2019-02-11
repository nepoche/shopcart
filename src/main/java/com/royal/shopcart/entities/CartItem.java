package com.royal.shopcart.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@Entity
public class CartItem {

    public CartItem(Product p, Integer q) {
        product = p;
        quantity = q;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Product product;

    @NotNull
    private Integer quantity;

    public double getPrice() {
        return product.getPrice() * quantity;
    }
}
