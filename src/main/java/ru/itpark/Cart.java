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
            if (!cartForGoods.containsKey(goods)) {
                cartForGoods.put(goods, 1);
            } else {
                cartForGoods.merge(goods, 1, Integer::sum);
            }

            amount += goods.getPrice();
            amountIncludingDiscounts += goods.getPriceIncludingDiscount();
            numberOfGoods++;
    }

    public void remove(Goods goods) {
            if (cartForGoods.containsKey(goods)) {
                int quantity = cartForGoods.get(goods) - 1;
                // Удаляю каждый раз и создаю c новым значением, так как не знаю как убавлять значение в HashMap'e, как сделал это с увелечением значения в методе add();
                cartForGoods.remove(goods);
                if (quantity != 0) {
                    cartForGoods.put(goods, quantity);
                }

                amount -= goods.getPrice();
                amountIncludingDiscounts -= goods.getPriceIncludingDiscount();
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
