package com.phua.lambdaexpression;

public class Credit {

    private int total;

    public int getTotal() {
        return total;
    }

    public Credit(int total) {
        this.total = total;
    }

    public int execute(Transaction transaction, int amount) {
        return transaction.operation(amount);
    }

}
