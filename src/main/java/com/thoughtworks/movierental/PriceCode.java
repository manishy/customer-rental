package com.thoughtworks.movierental;

public interface PriceCode {
    int DEFAULT_RENTAL_POINTS = 1;
    int BONUS_RENTAL_POINTS = 2;


    double amountFor(int daysRented);
    int frequentRenterPoints(int daysRented);
}
