package org.soulaimane.orderservice.exceptions;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(String orderNotFound) {
        super(orderNotFound);
    }
}
