package com.thoughtworks.movierental;

public class TextStatement implements Statement {
    private final String name;
    private final Rentals rentals;

    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
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

    private String footer() {
        String footer = "";
        footer += "Amount owed is " + rentals.totalAmount() + "\n";
        footer += "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
        return footer;
    }
}
