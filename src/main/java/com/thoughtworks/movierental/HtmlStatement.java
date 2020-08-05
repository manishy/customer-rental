package com.thoughtworks.movierental;

public class HtmlStatement {
    private final String name;
    private final Rentals rentals;

    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlFooter() {
        String footer = "";
        footer += "Amount owed is " + "<b>" + rentals.totalAmount() + "</b><br/>";
        footer += "You earned " + "<b>" + rentals.frequentRenterPoints() + "</b>"
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
