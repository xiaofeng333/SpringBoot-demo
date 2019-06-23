package com.feng.springboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner和CommandLineRunner同义, 可在项目启动后做一些事情
 * 定义多个可以通过Order注解来指定顺序或实现Ordered接口
 */
@Component
@Order(2)
public class MyApplicationRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("MyApplicationRunner run...");
    }
}
