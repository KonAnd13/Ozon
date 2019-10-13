package ru.itpark.service;

import ru.itpark.model.Good;
import java.util.*;

public class Cart {
    private Map<Good, Integer> cartForGoods = new HashMap<>();
    private int amount;
    private int amountIncludingDiscounts;
    private int numberOfGoods;

    public int getAmount() {
        return amount;
    }

    public int getAmountIncludingDiscounts() {
        return amountIncludingDiscounts;
    }

    public int getNumberOfGoods() {
        return numberOfGoods;
    }

    public void add(Good good) {
            if (!cartForGoods.containsKey(good)) {
                cartForGoods.put(good, 1);
            } else {
                cartForGoods.merge(good, 1, Integer::sum);
            }

            amount += good.getPrice();
            amountIncludingDiscounts += good.getPriceIncludingDiscount();
            numberOfGoods++;
    }

    public void remove(Good good) {
            if (cartForGoods.containsKey(good)) {
                int quantity = cartForGoods.get(good) - 1;
               
                if (quantity == 0) {
                    cartForGoods.remove(good);
                } else {
                    cartForGoods.put(good, quantity);
                }

                amount -= good.getPrice();
                amountIncludingDiscounts -= good.getPriceIncludingDiscount();
                numberOfGoods--;
            }
    }

    @Override
    public String toString() {
        return  "Ваша корзина\t\t\t" + numberOfGoods + " товара(ов)" +
                "\nТовары (" + numberOfGoods + ")\t\t\t\t" + amount + " ₽" +
                "\nСкидка\t\t\t\t\t-" + (amount - amountIncludingDiscounts) + " ₽" +
                "\nОбщая стоимость:\t\t" + amountIncludingDiscounts + " ₽";
    }
}
