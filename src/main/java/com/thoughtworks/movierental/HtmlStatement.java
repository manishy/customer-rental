package com.thoughtworks.movierental;

public class HtmlStatement implements Statement {
    private final String name;
    private final Rentals rentals;

    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String footer() {
        String footer = "";
        footer += "Amount owed is " + "<b>" + rentals.totalAmount() + "</b><br/>";
        footer += "You earned " + "<b>" + rentals.frequentRenterPoints() + "</b>"
                + " frequent renter points";
        return footer;
    }

    private String body() {
        String body = "";
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            body += " " + rental.getMovie().getTitle() +
                    " <b>" + rentalAmount + "</b>" + "<br/>";
        }
        return body;
    }

    private String header() {
        return "<h1> " + "Rental Record for " + name + " </h1>";
    }
}
