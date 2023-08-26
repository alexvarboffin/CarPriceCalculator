package com.walhalla.clicker;

public class CarPriceCalculator {
    private double basePrice;
    private double optionsPrice;
    private double taxRate;

    public CarPriceCalculator(double basePrice, double optionsPrice, double taxRate) {
        this.basePrice = basePrice;
        this.optionsPrice = optionsPrice;
        this.taxRate = taxRate;
    }

    public double calculatePrice() {
        double totalPrice = basePrice + optionsPrice;
        double taxAmount = totalPrice * (taxRate / 100);
        return totalPrice + taxAmount;
    }
}