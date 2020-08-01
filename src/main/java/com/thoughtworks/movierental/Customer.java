package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String footer() {
        String footer = "";
        int frequentRenterPoints = frequentRenterPoints();
        double totalAmount = totalAmount();
        footer += "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return footer;
    }

    private String body() {
        String body = "";
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            body += "\t" + rental.getMovie().getTitle() + "\t" +
                    rentalAmount + "\n";
        }
        return body;
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            totalAmount += rentalAmount;
        }
        return totalAmount;
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}

