package com.steve.testReactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GreetingHandler {
    private static final Logger log = LoggerFactory.getLogger(GreetingHandler.class);

    public Mono<ServerResponse> hello(ServerRequest request) {

        var patchers = List.of(new patcherOne(), new patcherTwo());
        patchers.forEach(patcher -> {
            try{
                patcher.run();
            } catch (InterruptedException e) {
                log.info("Interrupted");
            }
        });

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(new Greeting("Hello, Steve!")));
    }
}