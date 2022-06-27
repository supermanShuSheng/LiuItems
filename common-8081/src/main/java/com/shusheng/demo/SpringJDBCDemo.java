package com.shusheng.demo;

import cn.hutool.db.handler.BeanListHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @author 刘闯
 * @date 2021/7/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJDBCDemo {

    // 获取数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void getDateSource(){
        System.out.println("获取数据源： "+dataSource.getClass());

        // 获取连接
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from user";
            // 执行
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 获取执行结果
            ResultSet resultSet = preparedStatement.executeQuery();

            // 使用工具类来进行获取  BeanHandler == 单个实体对象    BeanListHandler == List实体对象    MapHandler  == 不确定的单个实体对象     MapListHandler  == 不确定的Map集合
            BeanListHandler<Object> obj = new BeanListHandler<>(Object.class);
            // 解析对象
            List<Object> handle = obj.handle(resultSet);

            System.out.println("结果为： "+handle);

            // 使用迭代来进行获取    ResultSet只能被消费一次  如果上面代码也执行的话下面代码是空的
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String age = resultSet.getString("age");
                System.out.println("age = " + age + " id = " + id);
            }

            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void getTemplate(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println("查询结果为： " + maps);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql = "select * from user";
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/shusheng?serverTimezone=Asia/Shanghai",
                        "root","root");
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        // 执行SQL
        ResultSet resultSet = preparedStatement.executeQuery();
//
//        // 使用工具类来进行获取  BeanHandler == 单个实体对象    BeanListHandler == List实体对象    MapHandler  == 不确定的单个实体对象     MapListHandler  == 不确定的Map集合
//        BeanListHandler<Object> obj = new BeanListHandler<>(Object.class);
//        // 解析对象
//        List<Object> handle = obj.handle(resultSet);
//
//        System.out.println("结果为： "+handle);
    }

    @Test
    public void getABC(){

    }


}
