package ru.itpark;

import java.util.*;

public class Cart {
    private Map<Goods, Integer> cartForGoods = new HashMap<>();
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

    public void add(Goods goods) {
        if (goods instanceof Lego) {
            Lego lego = (Lego) goods;

            if (!cartForGoods.containsKey(lego)) {
                cartForGoods.put(lego, 1);
            } else {
                cartForGoods.merge(lego, 1, Integer::sum);
            }

            amount += lego.getPrice();
            amountIncludingDiscounts += lego.getPriceIncludingDiscount();
            numberOfGoods++;
        }
    }

    public void remove(Goods goods) {
        if (goods instanceof Lego) {
            Lego lego = (Lego) goods;
            if (cartForGoods.containsKey(lego)) {
                int quantity = cartForGoods.get(lego) - 1;
                // Удаляю каждый раз и создаю c новым значением, так как не знаю как убавлять значение в HashMap'e, как сделал это с увелечением значения в методе add();
                cartForGoods.remove(lego);
                if (quantity != 0) {
                    cartForGoods.put(lego, quantity);
                }

                amount -= lego.getPrice();
                amountIncludingDiscounts -= lego.getPriceIncludingDiscount();
                numberOfGoods--;
            }
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
