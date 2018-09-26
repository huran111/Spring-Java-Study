package com.hr.suanfa;

import java.util.Scanner;

/**
 * @author BUCHU
 * @Title: Main
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2614:29
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=============>>>请输入一个整数:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int number1 = Integer.valueOf(s);
        int number2 = Integer.parseInt(new StringBuilder(s).reverse().toString());
        System.out.println(number1 + number2);
    }
}
