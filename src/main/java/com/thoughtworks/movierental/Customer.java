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

    public String textStatement() {
        TextStatement textStatement = new TextStatement(name, rentals, frequentRenterPoints(), totalAmount());
        return textStatement.generate();
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

    public String htmlStatement() {
        HtmlStatement htmlStatement = new HtmlStatement(name, rentals, frequentRenterPoints(), totalAmount());
        return htmlStatement.generate();
    }
}

