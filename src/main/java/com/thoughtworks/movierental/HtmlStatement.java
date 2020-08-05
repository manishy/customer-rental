package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {
    private final String name;
    private final List<Rental> rentals;
    private final int frequentRenterPoints;
    private final double totalAmount;

    public HtmlStatement(String name, List<Rental> rentals, int frequentRenterPoints, double totalAmount) {
        this.name = name;
        this.rentals = rentals;
        this.frequentRenterPoints = frequentRenterPoints;
        this.totalAmount = totalAmount;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlFooter() {
        String footer = "";
        footer += "Amount owed is " + "<b>" + totalAmount + "</b><br/>";
        footer += "You earned " + "<b>" + frequentRenterPoints + "</b>"
                + " frequent renter points";
        return footer;
    }

    private String htmlBody() {
        String body = "";
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            body += " " + rental.getMovie().getTitle() +
                    " <b>" + rentalAmount + "</b>" + "<br/>";
        }
        return body;
    }

    private String htmlHeader() {
        return "<h1> " + "Rental Record for " + name + " </h1>";
    }
}
