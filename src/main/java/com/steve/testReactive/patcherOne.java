package com.steve.testReactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class patcherOne implements PatcherInterface {
    private static final Logger log = LoggerFactory.getLogger(patcherOne.class);
    @Autowired
    WebClient webClient = WebClient.builder().build();

    public void run() throws InterruptedException {
        log.info("Patcher One has begun");

        longRunningThing().subscribe(data -> {
            log.info("The long running Thing replied:" + data);
        });
    }

    private Mono<String> longRunningThing() throws InterruptedException {

        return webClient.get().uri("https://httpbin.org/delay/10").retrieve().bodyToMono(String.class);
    }
}