package com.shusheng.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author 刘闯
 * @date 2021/7/12.
 */
public class ValidatorUtils {

    private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    /**
     * 校验
     * @param t 对象
     * @return 成功：success  失败：错误信息
     */
    public static <T> String validatorBean(T t){
        Set<ConstraintViolation<T>> validate = getViolation(t);
        if (validate.size() == 0){
            return "success";
        }
        return validate.stream().findFirst().get().getMessage();
    }

    /**
     * 校验 如果不合法则直接像外抛出（自定义异常）
     * @param t 对象
     * @param bool 如果为true则不合法直接抛出异常  否则会给出信息
     * @return 结果
     */
    public static <T> String validatorBean(T t, boolean bool){
        Set<ConstraintViolation<T>> validate = getViolation(t);
        // 如果不合法 则抛出异常
        if (validate.size() > 0 && bool){
            throw new RuntimeException(validate.stream().findFirst().get().getMessage());
        }
        return validatorBean(t);
    }

    /**
     * 获取校验值
     * @param t 对象
     * @return set错误集合对象
     */
    private static <T> Set<ConstraintViolation<T>> getViolation(T t){
        // 获取校验类
        Validator validator = validatorFactory.getValidator();
        return validator.validate(t);
    }
}
