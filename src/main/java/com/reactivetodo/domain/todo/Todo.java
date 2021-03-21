package com.reactivetodo.domain.todo;

import com.reactivetodo.domain.BaseTimeEntity;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Document(collection = "todo")
public class Todo extends BaseTimeEntity {

	@MongoId
	private String id;

	private Long memberId;

	private String title;

	public Todo(String title) {
		this.title = title;
	}

}
