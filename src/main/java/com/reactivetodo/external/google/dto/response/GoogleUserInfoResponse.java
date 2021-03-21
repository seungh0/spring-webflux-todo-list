package com.reactivetodo.external.google.dto.response;

import com.reactivetodo.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class GoogleUserInfoResponse {

	private String id;

	private String email;

	private String name;

	private String picture;

	private String locale;

	public Member toEntity() {
		return Member.newInstance(email, name);
	}

}