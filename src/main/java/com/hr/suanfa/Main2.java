package com.hr.suanfa;

import java.util.Scanner;

/**
 * @author BUCHU
 * @Title: Main2
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2614:18
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println("请输入要获取的硬币数量");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (count>=1){
            if(count%2==0){
                count=(count-2)/2;
                stringBuilder.append("2");
            }else {
                count=(count-1)/2;
                stringBuilder.append("1");
            }
        }
        System.out.println(stringBuilder.reverse());
    }
}
