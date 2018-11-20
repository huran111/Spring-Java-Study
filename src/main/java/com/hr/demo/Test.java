package com.hr.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huran
 * @Title: Test
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2515:50
 */
public class Test {
    public static void main(String[] args) {
       List<Integer> items=new ArrayList<>();
       items.add(0);
      /*  items.add(1);
        items.add(2);

        items.add(3);

        items.add(4);

        items.add(5);
        items.add(6);
        items.add(7);
        items.add(8);*/
        List<Integer> curSplits = new ArrayList<>();
int totalSharding=9;
int totalSplit=100;
        // 1-10   2  11-20  3   21-30  4  31-40
  int pagesize=100/totalSharding;

    int item=0;
            for(Integer i = 0; i < pagesize; i++) {
                Integer index = item * pagesize + i;
                curSplits.add(index);
            }
            if (item == (totalSharding - 1)) {
                for (int j = (item + 1) * pagesize; j < totalSplit; j++) {
                    curSplits.add(j);
                }
            }

      curSplits.forEach(System.out::println);

    }
}
