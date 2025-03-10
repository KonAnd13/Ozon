package ru.itpark;

import ru.itpark.model.Lego;
import ru.itpark.service.Cart;

public class Main {
    public static void main(String[] args) {
        Lego lego_1 = new Lego(
                143327311,
                "https://www.ozon.ru/context/detail/id/143327311/",
                "https://cdn1.ozone.ru/multimedia/c1200/1021657753.JPG",
                "LEGO City Great Vehicles Дом на колесах Конструктор",
                143327311,
                1999,
                36,
                "Бестселлер",
                5,
                119,
                344,
                "Пластиковый конструктор",
                "LEGO City",
                5
        );

        Lego lego_2 = new Lego(
                154342351,
                "https://www.ozon.ru/context/detail/id/154342351/",
                "https://cdn1.ozone.ru/multimedia/c1200/1037592368.jpg",
                "LEGO Hidden Side Трюковый грузовик Эль-Фуэго Конструктор",
                154342351,
                2999,
                33,
                "Бестселлер",
                5,
                1,
                4,
                "Пластиковый конструктор",
                "Hidden Side (LEGO)",
                8
        );

        Lego lego_3 = new Lego(
                154342355,
                "https://www.ozon.ru/context/detail/id/154342355/",
                "https://cdn1.ozone.ru/multimedia/c1200/1037592160.jpg",
                "LEGO Hidden Side Школа с привидениями Ньюбери Конструктор",
                154342355,
                9499,
                33,
                "Бестселлер",
                5,
                4,
                71,
                "Пластиковый конструктор",
                "Hidden Side (LEGO)",
                9
        );

        Cart cart = new Cart();
        cart.add(lego_1);
        cart.add(lego_1);
        cart.add(lego_2);
        cart.add(lego_3);
        cart.add(lego_2);
        cart.remove(lego_1);
        cart.remove(lego_2);
        cart.remove(lego_2);

        System.out.println(cart);
    }
}
