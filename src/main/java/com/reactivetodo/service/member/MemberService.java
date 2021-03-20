package com.reactivetodo.service.member;

import com.reactivetodo.domain.member.MemberRepository;
import com.reactivetodo.service.member.dto.request.CreateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public void createMember(CreateMemberRequest request) {
		memberRepository.save(request.toEntity());
	}

}
