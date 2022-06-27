package com.shusheng.stream;

import com.alibaba.fastjson.JSONObject;
import com.shusheng.domain.Person;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 刘闯
 * @date 2021/2/4.
 */
public class ListStreamDemo {

    public static void main(String[] args) {

        // list对象
//         List<Person> list = getListData();
//         OperationStreamDemo1(list);
        // 静态
        //getStreamStatic();

        //list JSONObject
        List<JSONObject> list1 = getJSONObjectDate();

        List<JSONObject> collect = list1.stream().map(x -> {
            if (StringUtils.equals(x.getString("1"), "小明")) {
                x.put("1", "OOOOOOOOOOOO");
            }
            return x;
        }).collect(Collectors.toList());

        System.out.println("collect = " + collect);
        //OperationStreamDemo(list1);
    }
    public static List<JSONObject> getJSONObjectDate(){
        List<JSONObject> list = new ArrayList<>();
        JSONObject k = new JSONObject();
        k.put("1","张三");
        k.put("2","李四");
        k.put("3","王二");
        list.add(k);
        JSONObject k1 = new JSONObject();
        k1.put("1","小明");
        k1.put("2","小红");
        k1.put("3","小张");
        list.add(k1);
        JSONObject k2 = new JSONObject();
        k2.put("1","小明");
        k2.put("2","小红");
        k2.put("3","小张");
        list.add(k2);
        return list;
    }

    /**
     * 获取List对象
     * @return list
     */
    public static List<Person> getListData(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"张三",30));
        list.add(new Person(2,"李四",19));
        list.add(new Person(3,"王二",20));
        return list;
    }

    /**
     * 操作Stream流的静态方法
     */
    public static void getStreamStatic(){

        // 累加  如果不适用limit进行截取 则一直执行下去
        Stream<Integer> limit = Stream.iterate(0, x -> {
            x = x + 2;
            if (x == 10) {
                return 0;
            }
            return x;
        }).limit(5);
        limit.forEach(System.out::println);

        // 生成随机流
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);

        Stream.generate(() -> new Random().nextInt(10)).limit(5)
                .forEach(x -> {
                    System.out.println("获取的随机数为 = " + x);
                });

    }


    /**
     * 操作Stream流
     * @param list 数组
     */
    public static void OperationStreamDemo(List<JSONObject> list){
        List<JSONObject> list1 = list.stream()
                .filter(x -> x.getString("3").equals("张三"))
                .collect(Collectors.toList());
        System.out.println("list1 = " + list1);

        System.out.println("list = " + list);


        // 分组
        Map<String, List<JSONObject>> collect = list.stream()
                .collect(Collectors.groupingBy(x -> x.getString("3")));
        System.out.println("collect = " + collect);

        // 对数据进行组合
        String collect1 = list.stream()
                .map((x) -> x.getString("1"))
                .collect(Collectors.joining(","));
        System.out.println("collect1 = " + collect1);

        // 根据key为3的value值进行分组  然后只取名称  转化为数组
        Map<String, List<String>> collect2 = list.stream()
                .collect(Collectors.groupingBy(x -> x.getString("3"),  // 上游收集器
                        // 通过mapper函数来处理List中的每一个数据
                        Collectors.mapping(x -> x.getString("2"),  // 下游收集器
                                Collectors.toList())));
        System.out.println("collect2 = " + collect2);
    }

    /**
     * 操作Stream流
     * @param list 数组
     */
    public static void OperationStreamDemo1(List<Person> list){
        list.add(new Person(5,"黄色",24));
        list.add(new Person(5,"黄色",28));

        System.out.println("list = " + list);
        List<Person> collect = list.stream()
                //  筛选 ID为2的
                .filter((x) -> {
                    System.out.println("x = " + x);
                    return x.getId() == 2;
                })
                //  转化为 List数组
                .collect(Collectors.toList());
        System.out.println("List流筛选数组 = " + collect);

        List<Person> collect1 = list.stream()
                .filter(distinctByKey(Person::getId))
                .collect(Collectors.toList());
        System.out.println("List对象去除重复数据 = " + collect1);

        // 进行排序
        List<Person> collect2 = list.stream()
//              .sorted(Comparator.comparingInt(Person::getAge).reversed())   倒序
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("List根据对象年龄排序升序 = " + collect2);

        List<Person> collect6 = list.stream()
                .sorted((x, y) -> {
                    // 如果名字相同
                    if (x.getName().equals(y.getName())) {
                        return x.getAge() - y.getAge();
                    }
                    return x.getName().compareTo(y.getName());
                })
                .collect(Collectors.toList());
        System.out.println("List按名称排序 如果名称相同则按照年龄排序 = " + collect6);

        // 另一种写法
        List<Person> collect6_2 = list.stream()
                .sorted(Comparator.comparing(Person::getName).reversed().thenComparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
        System.out.println("List按名称排序 如果名称相同则按照年龄排序 = " + collect6_2);

        // peek用来修改数据,map用来转换数据类型
        List<Person> collect7 = list.stream()
                .peek((x) ->{
                    x.setAge(18);
                })
                .collect(Collectors.toList());

        System.out.println("批量修改list里对应值 = " + collect7);

        List<Person> collect3 = list.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("List截取前x个数据 = " + collect3);

        List<Person> collect4 = list.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("List去除前x个数据 = " + collect4);

        List<String> collect5 = list.stream()
                .map((x) -> {
                    if (x.getId()==1){
                        return x.getName();
                    }
                    return null;
                })
                // 生成后去重
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List通过名字进行转换类型 = " + collect5);

        boolean b = list.stream()
                .anyMatch(person -> person.getAge() == 50);
        System.out.println("判断流中的是否有年龄为xx的 = " + b);

        //  parallelStream   可以并行随机获取
        //  使用stream时  findFirst  findAny  都是获取的第一个元素
        Optional<String> first = list.parallelStream()
                .map(Person::getName)
                //.findFirst(); 获取第一个元素
                .findAny();
        System.out.println("first.orElse(\"我是else\") = " + first.orElse("我是else"));

        System.out.println("first.get() = " + first.get());

        Optional<Integer> reduce = list.stream()
                .map(Person::getAge)
                .reduce(Integer::sum);
        // 0是初始值 acc想当与迭代参数  item相当于每次的参数

        System.out.println("对获取的数据进行相+ = " + reduce.get());

        // forEach遍历
        list.forEach(System.out::println);

        // 获取最大值
        Person person = list.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get();
        System.out.println("person = " + person);


    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }



}
