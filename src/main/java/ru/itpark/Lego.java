package ru.itpark;

public class Lego extends Goods {
    private String type;
    private String series;
    private int childAge;

    public Lego(String URL, String imageUrl, String name, int productCode, int price, double discount, String popularity, int rating, int reviews, int amountOfElements, String type, String series, int childAge) {
        super(URL, imageUrl, name, productCode, price, discount, popularity, rating, reviews, amountOfElements);
        this.type = type;
        this.series = series;
        this.childAge = childAge;
    }
}