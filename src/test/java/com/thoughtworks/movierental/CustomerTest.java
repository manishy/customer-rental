package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void ShouldGenerateStatementForChildrenMovies() {
        Customer manish = new Customer("manish");
        Movie chhichhore = new Movie("Chhichhore", 2);
        Rental chhichhoreRental = new Rental(chhichhore, 5);

        manish.addRental(chhichhoreRental);
        String statement = manish.statement();
        String expectedStatement = "Rental Record for manish\n" +
                "\tChhichhore\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateStatementForRegularMovies() {
        Customer manish = new Customer("manish");
        Movie kingKong = new Movie("King kong", 0);
        Rental kingKongRental = new Rental(kingKong, 5);

        manish.addRental(kingKongRental);
        String statement = manish.statement();
        String expectedStatement = "Rental Record for manish\n" +
                "\tKing kong\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateStatementForNewReleaseMovies() {
        Customer manish = new Customer("manish");
        Movie kingKong = new Movie("King kong", 1);
        Rental kingKongRental = new Rental(kingKong, 3);

        manish.addRental(kingKongRental);
        String statement = manish.statement();
        String expectedStatement = "Rental Record for manish\n" +
                "\tKing kong\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void ShouldGenerateStatementForAllMovies() {
        Customer manish = new Customer("manish");
        Movie kingKong = new Movie("King kong", 0);
        Movie threeIdiots = new Movie("Three idiots", 1);
        Movie chhichhore = new Movie("Chhichhore", 2);
        Rental kingKongRental = new Rental(kingKong, 5);
        Rental threeIdiotsRental = new Rental(threeIdiots, 5);
        Rental chhichhoreRental = new Rental(chhichhore, 5);

        manish.addRental(kingKongRental);
        manish.addRental(threeIdiotsRental);
        manish.addRental(chhichhoreRental);
        String statement = manish.statement();
        String expected = "Rental Record for manish\n" +
                "\tKing kong\t6.5\n" +
                "\tThree idiots\t15.0\n" +
                "\tChhichhore\t4.5\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points";
        assertEquals(expected, statement);
    }

}
