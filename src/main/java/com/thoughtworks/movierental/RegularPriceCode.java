package com.thoughtworks.movierental;

public class RegularPriceCode implements PriceCode {

    public static final double PRICE_PER_DAY = 1.5;

    public double amountFor(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * PRICE_PER_DAY;
        return amount;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return DEFAULT_RENTAL_POINTS;
    }
}
