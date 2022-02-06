package com.suj.java8feature.lambdaExpression.Interface;

public interface IFuncInter {
    void operate(int num1, String inputStr);
    //Default method
    default void display(){
        System.out.println("Default method of IFuncInter abstract interface is being called");
    }
}
