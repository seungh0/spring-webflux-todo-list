package com.reactivetodo.controller.auth;

import com.reactivetodo.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class AuthController {

	private final AuthService authService;

	@GetMapping("/api/v1/auth/google")
	public Mono<String> handleGoogleAuthentication(String code, String redirectUri) {
		return authService.handleGoogleAuthentication(code, redirectUri);
	}

}
