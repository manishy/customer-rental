package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer = new Customer("Manish");
    private Rental childrenMovieRental = new Rental(new Movie("Chhichhore", Movie.CHILDRENS), 5);
    private Rental regularMovieRental = new Rental(new Movie("Love aazkl", Movie.REGULAR), 5);
    private Rental newReleaseMovieRental = new Rental(new Movie("Three idiots", Movie.NEW_RELEASE), 3);
    private Rental bluRayMovieRental = new Rental(new Movie("crook", Movie.BLU_RAY), 4);

    @Test
    public void ShouldGenerateTextStatementForChildrenMovies() {
        customer.addRental(childrenMovieRental);
        String statement = customer.textStatement();
        String expectedStatement = "Rental Record for Manish\n" +
                "\tChhichhore\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateTextStatementForRegularMovies() {
        customer.addRental(regularMovieRental);
        String statement = customer.textStatement();
        String expectedStatement = "Rental Record for Manish\n" +
                "\tLove aazkl\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateTextStatementForNewReleaseMovies() {
        customer.addRental(newReleaseMovieRental);
        String statement = customer.textStatement();
        String expectedStatement = "Rental Record for Manish\n" +
                "\tThree idiots\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateTextStatementForBluRayMovies() {
        customer.addRental(bluRayMovieRental);
        String statement = customer.textStatement();
        String expectedStatement = "Rental Record for Manish\n" +
                "\tcrook\t16.0\n" +
                "Amount owed is 16.0\n" +
                "You earned 3 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateTextStatementForAllMovies() {
        customer.addRental(regularMovieRental);
        customer.addRental(newReleaseMovieRental);
        customer.addRental(childrenMovieRental);
        customer.addRental(bluRayMovieRental);
        String statement = customer.textStatement();
        String expectedStatement = "Rental Record for Manish\n" +
                "\tLove aazkl\t6.5\n" +
                "\tThree idiots\t9.0\n" +
                "\tChhichhore\t4.5\n" +
                "\tcrook\t16.0\n" +
                "Amount owed is 36.0\n" +
                "You earned 7 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateHtmlStatementForAllMovies() {
        customer.addRental(regularMovieRental);
        customer.addRental(newReleaseMovieRental);
        customer.addRental(childrenMovieRental);
        String statement = customer.htmlStatement();
        String expectedStatement = "<h1> Rental Record for Manish </h1>" +
                " Love aazkl <b>6.5</b>" +
                "<br/> Three idiots <b>9.0</b>" +
                "<br/> Chhichhore <b>4.5</b>" +
                "<br/>Amount owed is <b>20.0</b>" +
                "<br/>You earned <b>4</b> frequent renter points";
        assertEquals(expectedStatement, statement);
    }

}
