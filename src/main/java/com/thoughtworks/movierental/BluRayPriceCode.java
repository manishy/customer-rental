package com.thoughtworks.movierental;

public class BluRayPriceCode implements PriceCode {

    public static final int PRICE_PER_DAY = 4;
    public static final int RENTAL_POINTS = 3;

    @Override
    public double amountFor(int daysRented) {
        return daysRented * PRICE_PER_DAY;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return RENTAL_POINTS;
    }
}
