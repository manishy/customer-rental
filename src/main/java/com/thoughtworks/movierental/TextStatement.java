package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private final String name;
    private final List<Rental> rentals;
    private int frequentRenterPoints;
    private double totalAmount;

    public TextStatement(String name, List<Rental> rentals, int frequentRenterPoints, double totalAmount) {
        this.name = name;
        this.rentals = rentals;
        this.frequentRenterPoints = frequentRenterPoints;
        this.totalAmount = totalAmount;
    }

    public String generate() {
        return textHeader() + textBody() + textFooter();
    }

    private String textHeader() {
        return "Rental Record for " + name + "\n";
    }

    private String textBody() {
        String body = "";
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            body += "\t" + rental.getMovie().getTitle() + "\t" +
                    rentalAmount + "\n";
        }
        return body;
    }

    private String textFooter() {
        String footer = "";
        footer += "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return footer;
    }
}
