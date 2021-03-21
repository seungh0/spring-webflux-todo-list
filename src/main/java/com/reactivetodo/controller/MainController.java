package com.reactivetodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class MainController {

	@GetMapping("/ping")
	public Mono<String> ping() {
		return null;
	}

}
