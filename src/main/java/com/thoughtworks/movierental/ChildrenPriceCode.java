package com.thoughtworks.movierental;

public class ChildrenPriceCode implements PriceCode {

    public static final double PRICE_PER_DAY = 1.5;

    public double amountFor(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * PRICE_PER_DAY;
        return amount;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return DEFAULT_RENTAL_POINTS;
    }
}
