package com.phua.moneycurrency;

import java.util.Currency;
import java.util.Locale;

public class Account {

    private Locale locale;
    private int amount;
    private Currency currency;

    public Account(Locale locale, int amount) {
        this.locale = locale;
        this.amount = amount;
        this.currency = Currency.getInstance(locale);
    }

    public int getAmount() {
        return amount;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void status() {
        System.out.println(amount + " " + currency.getCurrencyCode() + " in the account");
    }

    public void deposit(int deposit) {
        amount += deposit;
        System.out.println(deposit + " " + currency.getCurrencyCode() + " deposited");
    }

    public void withdraw(int w) {
        if (w < amount) {
            amount -= w;
            System.out.println(w + " " + currency.getCurrencyCode() + " withdrawed");
        } else {
            System.out.println("You can't withdraw  " + w + " " + currency.getCurrencyCode() + "!");
        }

    }
}
