package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;
    private static final int BONUS_RENTAL_POINTS = 2;
    private static final int DEFAULT_RENTAL_POINTS = 1;


    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double amount() {
        return movie.priceCode().amountFor(daysRented);
    }


    public boolean isNewRelease() {
        return getMovie().getPriceCode() == Movie.NEW_RELEASE;
    }

    public boolean isBonusApplied() {
        return isNewRelease()
                &&
                getDaysRented() > 1;
    }

    public int frequentRenterPoints() {
        if (isBonusApplied()) {
            return BONUS_RENTAL_POINTS;
        }
        return DEFAULT_RENTAL_POINTS;
    }
}
