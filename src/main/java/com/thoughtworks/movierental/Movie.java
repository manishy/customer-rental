package com.thoughtworks.movierental;

public class Movie {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String title;
  private int priceCode;

  public Movie(String title, int priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  public int getPriceCode() {
    return priceCode;
  }

  public String getTitle() {
    return title;
  }

  public PriceCode priceCode() {
      switch (getPriceCode()) {
          case REGULAR:
              return new RegularPriceCode();
          case NEW_RELEASE:
              return new NewReleasePriceCode();
          case CHILDRENS:
              return new ChildrenPriceCode();
          default:
              return new DefaultPriceCode();
      }
  }
}
