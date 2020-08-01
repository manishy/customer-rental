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
        int frequentRenterPoints = frequentRenterPoints();
        double totalAmount = totalAmount();
        footer += "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return footer;
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
        return htmlHeader()+htmlBody()+htmlFooter();
    }

    private String htmlFooter() {
        String footer = "";
        int frequentRenterPoints = frequentRenterPoints();
        double totalAmount = totalAmount();
        footer += "Amount owed is " +"<b>"+ totalAmount +"</b><br/>";
        footer += "You earned " + "<b>"+ frequentRenterPoints+ "</b>"
                + " frequent renter points";
        return footer;
    }

    private String htmlBody() {
        String body = "";
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            body += " " + rental.getMovie().getTitle() +
                    " <b>"+rentalAmount+"</b>" + "<br/>";
        }
        return body;
    }

    private String htmlHeader() {
        return "<h1> "+"Rental Record for " + name + " </h1>";
    }
}

