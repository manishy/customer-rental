package com.thoughtworks.movierental;

public class NewReleasePriceCode {
    double amountFor(int daysRented) {
        return daysRented * 3;
    }
}
