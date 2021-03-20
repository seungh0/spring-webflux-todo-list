package com.reactivetodo.service.member.dto.request;

import com.reactivetodo.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMemberRequest {

	private String email;

	private String name;

	public Member toEntity() {
		return Member.newInstance(email, name);
	}

}
