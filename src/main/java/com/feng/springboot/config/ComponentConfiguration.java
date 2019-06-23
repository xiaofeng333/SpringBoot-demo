package com.feng.springboot.config;

import com.feng.springboot.component.KeyBoard;
import com.feng.springboot.component.LapTop;
import com.feng.springboot.component.Mouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ComponentConfiguration {

    @Bean
    @Profile("LapTop")
    public LapTop getLapTop() {
        return new LapTop();
    }

    @Bean
    @Profile("Mouse")
    public Mouse getMouse() {
        return new Mouse();
    }

    @Bean
    @Profile("KeyBoard")
    public KeyBoard getKeyBoard() {
        return new KeyBoard();
    }
}
