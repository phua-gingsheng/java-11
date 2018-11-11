package com.phua.interfacechanges;

public interface InterfaceSample {

    default void newMethod(){
        System.out.println("Newly added default method");
    }

    default void newMethodAgain() {
        System.out.println("Newly added default method again");
    }

    static void anotherNewMethod(){
        System.out.println("Newly added static method");
    }

    static void anotherNewMethodAgain(){
        System.out.println("Newly added static method again");
    }

    void existingMethod();

}
