package com.shusheng.stream;


import com.shusheng.domain.Item;
import com.shusheng.domain.People;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Collect使用Group分组
 * @author 刘闯
 * @date 2021/2/6.
 */
public class collectDemo {
    public static void main(String[] args) {
        collectDemo c = new collectDemo();
        c.test();
        c.test1();
    }
    public void test1(){
        List<String> list = Arrays.asList("小红","小张","小明");
        list.forEach(x->{
            System.out.println("x = " + x);
        });
    }


    public void test(){
        final int NUM = 14;
        List<People> peopleList = new ArrayList<>(NUM);
        String[] names = {"小张", "小龙", "小牛", "小猪", "小黑", "小红", "小白"};
        for (int i = 0; i < 5; i++) {
            //添加5个19岁的随机性别和名字的小朋友
            peopleList.add(new People(19, (int) (Math.random() * 2), names[(int) (Math.random() * names.length)]));
        }
        for (int i = 5; i < 8; i++) {
            //添加3个31岁的随机性别和名字的小朋友
            peopleList.add(new People(31, (int) (Math.random() * 2), names[(int) (Math.random() * names.length)]));
        }
        for (int i = 8; i < NUM; i++) {
            //添加6个22岁的随机性别和名字的小朋友
            peopleList.add(new People(22, (int) (Math.random() * 2), names[(int) (Math.random() * names.length)]));
        }

        //collectingAndThen先对stream里的元素进行collecting，之后再对结果进行操作，
        // 下面的结果是一个map,对map计算元素数目
        System.out.println("分组数目：");
        Integer groupCount = peopleList.stream().collect(
                // collectingAndThen 收集结果  然后进行分组  统计条目
                Collectors.collectingAndThen(Collectors.groupingBy(People::getName), Map::size));
        System.out.println(groupCount);
        System.out.println("-------------------------------------");


        //按照名字分组
        System.out.println("按照名字分组");
        Map<String, List<People>> collect = peopleList.stream().collect(Collectors.groupingBy(People::getName));
        collect.forEach((x,y)->{
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        });
        System.out.println("-------------------------------------");

        //按照名字分组(分组的结果是一个map)，并统计每一个分组(map中的每一个value)中的元素数目
        System.out.println("统计每一个分组(map中的每一个value)中的元素数目");
        System.out.println(
                peopleList.stream().collect(Collectors.groupingBy(People::getName, Collectors.counting()))
        );
        System.out.println("-------------------------------------");

        //按照名字分组(分组的结果是一个map)，并取出每一组的最大值
        System.out.println("取出每一组的最大值");
        System.out.println(
                peopleList.stream().collect(Collectors.groupingBy(People::getName, Collectors.maxBy(new Comparator<People>() {
                    @Override
                    public int compare(People o1, People o2) {
                        return o1.getAge() - o2.getAge();
                    }
                })))
        );
    }

    public static void GroupDemo() {
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getBigDecimal));

        System.out.println("groupByPriceMap = " + groupByPriceMap);

        // 先分组    在进行mapping收集   根据getName以名称来收集
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getBigDecimal,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        System.out.println("result = " + result);
    }
}
