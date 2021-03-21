package com.reactivetodo.service.todo.dto.response;

import com.reactivetodo.domain.todo.Todo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoInfoResponse {

	private final String id;

	private final String title;

	private final LocalDateTime createdDateTime;

	private final LocalDateTime updatedDateTime;

	public static TodoInfoResponse of(Todo todo) {
		return new TodoInfoResponse(todo.getId(), todo.getTitle(), todo.getCreatedDateTime(), todo.getUpdatedDateTime());
	}

}
