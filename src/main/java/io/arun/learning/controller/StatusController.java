package io.arun.learning.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api")
public class StatusController {

    @Get("/status")
    public String status() {
        return "Application is up and running";
    }

}
