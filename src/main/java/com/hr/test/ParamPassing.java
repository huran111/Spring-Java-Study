package com.hr.test;

import sun.swing.StringUIClientPropertyKey;

/**
 * @author huran
 * @Title: ParamPassing
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2912:47
 */
public class ParamPassing {
    private static int intStatis=222;
    private static  String stringStatis="old String";
    private static StringBuilder stringBuilder=new StringBuilder("old stringBuilder");

    public static void main(String[] args) {
                method(stringStatis);
                System.out.println(stringStatis);
                method( stringBuilder,stringBuilder);
                System.out.println(stringBuilder.toString());
    }
    public static void method(String stringBuilder){
        stringBuilder="aaaaa";
    }
    public static void method(StringBuilder stringBuilder, StringBuilder stringBuilder1){
        stringBuilder.append("1111");
        stringBuilder.append("2222");
        stringBuilder1=new StringBuilder("new StringBuilde3r");
        stringBuilder1.append("new method append");
    }
}
