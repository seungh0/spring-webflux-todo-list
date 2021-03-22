package com.reactivetodo.service.todo.dto.request;

import com.reactivetodo.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTodoRequest {

	private String title;

	public Todo toEntity() {
		return new Todo(title);
	}

}
