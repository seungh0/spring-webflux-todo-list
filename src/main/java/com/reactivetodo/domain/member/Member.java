package com.reactivetodo.domain.member;

import com.reactivetodo.domain.BaseTimeEntity;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Document(collection = "member")
public class Member extends BaseTimeEntity {

	@MongoId
	private String id;

	private String email;

	private String name;

	private Member(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public static Member newInstance(String email, String name) {
		return new Member(email, name);
	}

}
