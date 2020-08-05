package com.thoughtworks.movierental;

public class TextStatement {
    private final String name;
    private final Rentals rentals;

    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
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
        footer += "Amount owed is " + rentals.totalAmount() + "\n";
        footer += "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
        return footer;
    }
}
