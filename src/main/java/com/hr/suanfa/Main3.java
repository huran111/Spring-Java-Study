package com.hr.suanfa;

import java.util.Scanner;

/**
 * @author BUCHU
 * @Title: Main3
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2614:31
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //第一种方法
        while ((sc.hasNext())) {
            String s = sc.next();
            float count = 1;
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)!=s.charAt(i+1)){
                    count++;
                }
            }
            System.out.println(s.length()/count);
        }
        //第二种方法
        while (sc.hasNext()){
            String s=sc.next();
            float count=1;
            char[] string=s.toCharArray();
            for(int i=0;i<string.length-1;i++){
                if(string[i]!=string[i+1]){
                    count++;
                }
            }
            System.out.println(s.length()/count);
        }
    }
}
