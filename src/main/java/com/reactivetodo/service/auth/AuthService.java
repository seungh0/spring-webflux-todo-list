package com.reactivetodo.service.auth;

import com.reactivetodo.domain.member.Member;
import com.reactivetodo.domain.member.MemberRepository;
import com.reactivetodo.external.google.GoogleApiCaller;
import com.reactivetodo.external.google.dto.response.GoogleAccessTokenResponse;
import com.reactivetodo.external.google.dto.response.GoogleUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final GoogleApiCaller googleApiCaller;
	private final MemberRepository memberRepository;

	@Transactional
	public Mono<String> handleGoogleAuthentication(String code, String redirectUri) {
		GoogleAccessTokenResponse accessTokenResponse = googleApiCaller.getGoogleAccessToken(code, redirectUri);
		GoogleUserInfoResponse userInfoResponse = googleApiCaller.getGoogleUserProfileInfo(accessTokenResponse.getAccessToken());

		Mono<Member> memberMono = memberRepository.findByEmail(userInfoResponse.getEmail())
				.switchIfEmpty(memberRepository.save(userInfoResponse.toEntity()));
		// TODO: 토큰 or 세션을 생성
		return memberMono.map(Member::getId);
	}

}
