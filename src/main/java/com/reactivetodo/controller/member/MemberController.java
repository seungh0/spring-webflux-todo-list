package com.reactivetodo.controller.member;

import com.reactivetodo.service.member.MemberService;
import com.reactivetodo.service.member.dto.request.CreateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/api/v1/member")
	public Mono<String> createMember(@Valid @RequestBody CreateMemberRequest request) {
		memberService.createMember(request);
		return Mono.just("OK");
	}

}
