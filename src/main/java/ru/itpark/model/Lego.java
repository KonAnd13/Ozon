package ru.itpark.model;

public class Lego extends Good {
    private String type;
    private String series;
    private int childAge;

    public Lego(int id, String url, String imageUrl, String name, int productCode, int price, double discount, String popularity, int rating, int reviews, int amountOfElements, String type, String series, int childAge) {
        super(id, url, imageUrl, name, productCode, price, discount, popularity, rating, reviews, amountOfElements);
        this.type = type;
        this.series = series;
        this.childAge = childAge;
    }
}
