package ru.itpark;

public abstract class Goods {
    private String URL;
    private String imageUrl;
    private String name;
    private int productCode;
    private int price;
    private double discount;
    private int priceIncludingDiscount;
    private String popularity;
    private int rating;
    private int reviews;
    private int amountOfElements;

    public Goods(String URL, String imageUrl, String name, int productCode, int price, double discount, String popularity, int rating, int reviews, int amountOfElements) {
        this.URL = URL;
        this.imageUrl = imageUrl;
        this.name = name;
        this.productCode = productCode;
        this.price = price;
        this.discount = discount;
        this.priceIncludingDiscount = (int) (price * (1 - discount / 100));
        this.popularity = popularity;
        this.rating = rating;
        this.reviews = reviews;
        this.amountOfElements = amountOfElements;
    }


    public int getPrice() {
        return price;
    }

    public int getPriceIncludingDiscount() {
        return priceIncludingDiscount;
    }
}
