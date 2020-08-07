package com.thoughtworks.movierental;

public class DefaultPriceCode implements PriceCode {
    @Override
    public double amountFor(int daysRented) {
        return 0;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 0;
    }
}
