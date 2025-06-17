package com.examples;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();

        System.out.println(calc.add("1\n2,3"));
        System.out.println(calc.add("//[%]\n3%2"));
        System.out.println(calc.add("//[;;][p]\n3;;4p5000"));


    }
}
