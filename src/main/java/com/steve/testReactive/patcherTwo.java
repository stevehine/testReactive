package com.steve.testReactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class patcherTwo implements PatcherInterface {

    private static final Logger log = LoggerFactory.getLogger(patcherTwo.class);

    public void run() {
        log.info("Patcher Two has begun");
    }
}