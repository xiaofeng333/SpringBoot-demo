package com.feng.springboot;

import com.feng.springboot.doc.Swagger2;
import com.feng.springboot.properties.ProjectProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties({ProjectProperties.class})
@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Swagger2.active = true;
        // 在启动前设置重启失效, 会使devtools完全失效
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Application.class, args);
    }

    /**
     * 当系统退出时, 返回指定exit code
     */
    @Bean
    public ExitCodeGenerator getExitCodeGenerator() {
        return () -> 333;
    }
}
