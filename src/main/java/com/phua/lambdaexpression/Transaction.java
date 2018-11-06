package com.phua.lambdaexpression;

@FunctionalInterface
public interface Transaction {
    int operation(int amount);
}
