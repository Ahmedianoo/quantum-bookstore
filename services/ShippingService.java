package services;

import interfaces.Sendable;

public class ShippingService {
    public static void send(Sendable book, String address) {
        System.out.println("ShippingService: Shipped to " + address);
    }
}