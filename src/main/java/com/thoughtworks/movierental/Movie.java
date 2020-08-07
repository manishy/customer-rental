package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int BLU_RAY = 3;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public PriceCode priceCode() {
        switch (priceCode) {
            case REGULAR:
                return new RegularPriceCode();
            case NEW_RELEASE:
                return new NewReleasePriceCode();
            case CHILDRENS:
                return new ChildrenPriceCode();
            case BLU_RAY:
                return new BluRayPriceCode();
            default:
                return new DefaultPriceCode();
        }
    }
}
