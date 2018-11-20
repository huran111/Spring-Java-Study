package com.hr.lambda;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huran
 * @Title: DemoTest
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/239:29
 */
public class DemoTest {
    @Test
    public void demo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("传统方式");
            }
        }).start();
    }

    @Test
    public void demo2() {
        new Thread(() -> System.out.println("lambda表达式")).start();
    }

    @Test
    public void list() {
        List<String> list = Arrays.asList("java", "python", "scala");
        list.forEach(System.out::println);
        System.out.println();
        list.forEach(x -> System.out.println(x));
    }

    @Test
    public void map() {
        List<Double> cost = Arrays.asList(10.0, 14.54, 23.3453);
        cost.stream().map(x -> x + x * 3).forEach(x -> System.out.println(x));
    }

    @Test
    public void mapReduceTest() {
        List<Double> cost = Arrays.asList(10.0, 21.0, 12.0);
        double all = cost.stream().map(x -> x * 1).reduce((sum, x) -> sum + x).get();
        System.out.println(all);

    }

    @Test
    public void Stream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream()
                .forEach(System.out::println);
    }

    @Test
    public void parallelStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //可能是无序的
       /* numbers.parallelStream()
                .forEach(System.out::println);*/
        numbers.parallelStream().forEachOrdered(System.out::println);
    }

    @Test
    public void forkJoinPool() {
        System.out.println("hello world");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        //统计并执行list的线程
        Set<Thread> threadSet = new CopyOnWriteArraySet<>();
        //并行执行
        list.parallelStream().forEach(integer -> {
            Thread thread = Thread.currentThread();
            threadSet.add(thread);
        });
        System.out.println("threadSet一共有" + threadSet.size() + "个线程");
        System.out.println("系统一个有" + Runtime.getRuntime().availableProcessors() + "个cpu");
    }

    @Test
    public void aaa() throws InterruptedException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list1.add(i);
            list2.add(i);
        }
        Set<Thread> threadSetTwo = new CopyOnWriteArraySet<>();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread threadA = new Thread(() -> {
            list1.parallelStream().forEach(integer -> {
                Thread thread2 = Thread.currentThread();
                // System.out.println("list1" + thread);
                threadSetTwo.add(thread2);
            });
            countDownLatch.countDown();
        });
        Thread threadB = new Thread(() -> {
            list2.parallelStream().forEach(integer -> {
                Thread thread3 = Thread.currentThread();
                // System.out.println("list2" + thread);
                threadSetTwo.add(thread3);
            });
            countDownLatch.countDown();
        });
        threadA.start();
        threadB.start();
        countDownLatch.await();
        System.out.print("threadSetTwo一共有" + threadSetTwo.size() + "个线程");

        System.out.println("---------------------------");
        System.out.println(threadSetTwo);
        System.out.println("---------------------------");
        System.out.println(threadSetTwo);
        System.out.println("threadSetTwo一共有" + threadSetTwo.size() + "个线程");
        System.out.println("系统一个有" + Runtime.getRuntime().availableProcessors() + "个cpu");
    }

    @Test
    public void api() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("2017001", false, 0));
        users.add(new User("2017002", true, 36));
        users.add(new User("2017003", false, 98));
        users.add(new User("2017004", false, 233));
        users.add(new User("2017005", true, 68));
        users.add(new User("2017006", true, 599));
        users.add(new User("2017007", true, 1023));
        users.add(new User("2017008", false, 9));
        users.add(new User("2017009", false, 66));
        users.add(new User("2017010", false, 88));
        //普通实现方式
        ArrayList<User> tempArray = new ArrayList<>();
        ArrayList<String> idArray = new ArrayList<>(3);
        for (User user : users) {
            if (user.isVip()) {
                tempArray.add(user);
            }
        }
        tempArray.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getBalance() - o1.getBalance();
            }
        });
        for (int i = 0; i < 3; i++) {
            idArray.add(tempArray.get(i).getUserID());
        }
        for (int i = 0; i < idArray.size(); i++) {
            System.out.println(idArray.get(i));
        }


        List<String> array = users.stream().filter(User::isVip).sorted((t1, t2) -> t2.getBalance() - t1.getBalance()).limit(3)
                .map(User::getUserID).collect(Collectors.toList());
        array.forEach(System.out::println);


    }


    @Test
    public void streamApi() {
        String[] str = {"Hello World", "Jiaming Chen", "Zhouhang Cheng"};
        Stream<String> stream = Stream.of(str);
        String[] strArray = stream.toArray(String[]::new);
        stream.collect(Collectors.toList());
        stream.collect(Collectors.toCollection(ArrayList::new));
        stream.collect(Collectors.toSet());
    }

    @Test
    public void flatMap() {
        Stream<List<Integer>> inputStream =   Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,6));
        List<Integer> integerList=  inputStream.flatMap((childList)->childList.stream()).collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }

    @Test
    public  void  aaawq(){
        Calendar cale = null;
        cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
       System.out.println(firstday);
       Random random=new Random();
       for(int i=0;i<10;i++){
           int result=random.nextInt(4);
           System.out.println(result+1);
       }
  double a=493.0777999999992323232323232;
    double b=493.08;
    boolean c=a>b;
    System.out.println(c);
    }
}
