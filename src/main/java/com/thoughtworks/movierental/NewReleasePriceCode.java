package com.thoughtworks.movierental;

public class NewReleasePriceCode implements PriceCode {
    public double amountFor(int daysRented) {
        return daysRented * 3;
    }
}