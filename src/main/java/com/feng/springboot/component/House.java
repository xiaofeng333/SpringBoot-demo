package com.feng.springboot.component;

import com.feng.springboot.annotation.componet.CustomComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CustomComponent
public class House {
    private static final Logger logger = LoggerFactory.getLogger(House.class);

    public void describe() {
        logger.info("describe, it's very large");
    }
}
