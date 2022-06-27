package com.shusheng.interceptors;

import cn.hutool.core.date.DateUtil;
import com.shusheng.commons.CreateDate;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.data.annotation.CreatedDate;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Executor提供的方法中，update 包含了 新增，修改和删除类型，无法直接区分，需要借助 MappedStatement 类的属性
 *
 * Signature 对应 Invocation 构造器, type 为 Invocation.Object, method 为 Invocation.Method, args 为 Invocation.Object[]
 * method 对应的 update 包括了最常用的 insert/update/delete 三种操作, 因此 update 本身无法直接判断sql为何种执行过程
 * args 包含了其余多有的操作信息, 按数组进行存储, 不同的拦截方式有不同的参数顺序, 具体看type接口的方法签名, 然后根据签名解析, 参见官网
 * @author 刘闯
 * @date 2021/3/22.
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class InsertDateInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 根据签名指定的args顺序获取具体的实现类
        // 1. 获取MappedStatement实例, 并获取当前SQL命令类型
        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = ms.getSqlCommandType();
        // 2. 获取当前正在被操作的类, 有可能是Java Bean, 也可能是普通的操作对象, 比如普通的参数传递
        // 普通参数, 即是 @Param 包装或者原始 Map 对象, 普通参数会被 Mybatis 包装成 Map 对象
        // 即是 org.apache.ibatis.binding.MapperMethod$ParamMap
        Object parameter = invocation.getArgs()[1];
        if (parameter != null) {
            // 获取成员变量
            Field[] declaredFields = parameter.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                // insert 语句插入 createDate
                if (field.getAnnotation(CreateDate.class) != null) {
                    if (SqlCommandType.INSERT.equals(sqlCommandType) || SqlCommandType.UPDATE.equals(sqlCommandType)) {
                        field.setAccessible(true);
                        // 如果参数为空  则设置为当前时间
                        if (field.get(parameter) == null) {
                            field.set(parameter, DateUtil.now());
                        }
                    }
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
