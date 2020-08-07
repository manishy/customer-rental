package com.thoughtworks.movierental;

public class NewReleasePriceCode implements PriceCode {

    public double amountFor(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return BONUS_RENTAL_POINTS;
        return DEFAULT_RENTAL_POINTS;
    }
}
