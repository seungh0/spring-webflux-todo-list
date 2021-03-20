package com.reactivetodo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

	@GetMapping("/ping")
	public Mono<String> ping() {
		return Mono.just("pong");
	}

}
