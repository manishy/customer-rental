package com.thoughtworks.movierental;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String textStatement() {
        TextStatement textStatement = new TextStatement(name, rentals);
        return textStatement.generate();
    }

    public String htmlStatement() {
        HtmlStatement htmlStatement = new HtmlStatement(name, rentals);
        return htmlStatement.generate();
    }
}

