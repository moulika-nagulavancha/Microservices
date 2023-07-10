package com.learn.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-retry")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String getSomeSampleApiResponse() {
        logger.info("Sample API call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);

        return forEntity.getBody();
    }

    @GetMapping("/sample-circuitbreaker")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public String getSomeSampleApiResponseCB() {
        logger.info("Sample Circuit Breaker API call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);

        return forEntity.getBody();
    }

    @GetMapping("/sample-rate-limiter")
    @RateLimiter(name = "default")
    public String getSomeSampleApiResponseRateLimiter() {
        logger.info("Sample Circuit Breaker API call received");
        return "sample-api";
    }

    @GetMapping("/sample")
    @Bulkhead(name = "default")
    public String getSomeSampleApiResponseBulkHead() {
        logger.info("Sample Circuit Breaker API call received");
        return "sample-api";
    }

    public String hardcodedResponse(Exception exception) {
        return "Fallback Response";
    }
}
