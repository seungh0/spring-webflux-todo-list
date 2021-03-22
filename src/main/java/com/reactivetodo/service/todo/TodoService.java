package com.reactivetodo.service.todo;

import com.reactivetodo.domain.todo.Todo;
import com.reactivetodo.domain.todo.TodoRepository;
import com.reactivetodo.service.todo.dto.request.CreateTodoRequest;
import com.reactivetodo.service.todo.dto.response.TodoInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TodoService {

	private final TodoRepository todoRepository;

	@Transactional
	public Mono<TodoInfoResponse> createTodo(CreateTodoRequest request) {
		Mono<Todo> todo = todoRepository.save(request.toEntity());
		return todo.map(TodoInfoResponse::of);
	}

	@Transactional(readOnly = true)
	public Flux<TodoInfoResponse> getTodos() {
		Flux<Todo> todoFlux = todoRepository.findAll();
		return todoFlux.map(TodoInfoResponse::of);
	}

}
