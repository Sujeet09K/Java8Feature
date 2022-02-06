package com.suj.java8feature.lambdaExpression;

import com.suj.java8feature.lambdaExpression.Interface.IFuncInter;

public class LambdaExample {

    //Abstract function
    interface FuncInter1 {
        int operate (int num1, int num2);
    }

    interface FuncInter2{
        void display(String displayStr);
    }

    public static void main(String[] args) {
        LambdaExample instance = new LambdaExample();

        //Implementation of lambda expressions
        FuncInter1 add = ((num1, num2) -> {
            System.out.println("Num1 :"+num1+" Num2 :"+num2);
            return  (num1 + num2);
        });
        FuncInter1 multiple = ((num1, num2) -> num1 * num2);
        FuncInter2 displayString = (inputStr) -> System.out.println(inputStr);
        IFuncInter iterateDisplayString = ((num1, inputStr) -> {
            System.out.println("Displaying input string "+num1+" times");
            for (int i = 1; i <= num1; i++) {
                System.out.println(inputStr + "-" + i);
            }
        });

        //Calling lambda functions
        System.out.println("Addition of two numbers :: "+ add.operate(10,100));

        System.out.println("Multiplication of two numbers :: 10 and 100 : "+ multiple.operate(10,100));

        displayString.display("Displaying this random text");

        iterateDisplayString.display();

        iterateDisplayString.operate(10, "Number");
    }
}
