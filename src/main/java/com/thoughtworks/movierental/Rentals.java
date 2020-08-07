package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this) {
            PriceCode priceCode = rental.getMovie().priceCode();
            frequentRenterPoints += priceCode.frequentRenterPoints(rental.getDaysRented());
        }
        return frequentRenterPoints;
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            double rentalAmount = rental.amount();
            totalAmount += rentalAmount;
        }
        return totalAmount;
    }
}
