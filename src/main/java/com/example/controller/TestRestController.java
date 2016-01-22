package com.example.controller;

import com.example.entity.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by azaz on 22/01/16.
 */
@RestController
public class TestRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Data greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Data(counter.incrementAndGet(),String.format(template, name));
    }
}
