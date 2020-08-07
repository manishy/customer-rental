package com.thoughtworks.movierental;

public class RegularPriceCode implements PriceCode {
    public double amountFor(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }
}
