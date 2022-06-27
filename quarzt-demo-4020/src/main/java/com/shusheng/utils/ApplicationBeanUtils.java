package com.shusheng.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 刘闯
 * @date 2021/8/20.
 */
@Component
public class ApplicationBeanUtils implements ApplicationContextAware, BeanFactoryPostProcessor {

    // bean的上下文
    private static ConfigurableListableBeanFactory configurableListableBeanFactory;

    // 上下文
    private static ApplicationContext applicationContext;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ApplicationBeanUtils.configurableListableBeanFactory = configurableListableBeanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationBeanUtils.applicationContext = applicationContext;
    }

    /**
     * 获取对象
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T  getBean(Class<T> clazz) {
        return applicationContext != null?applicationContext.getBean(clazz):null;
    }

    /**
     * 获取对象
     *
     * @param name
     *
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) configurableListableBeanFactory.getBean(name);
    }

}
