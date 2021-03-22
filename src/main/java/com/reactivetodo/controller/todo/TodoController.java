package com.reactivetodo.controller.todo;

import com.reactivetodo.service.todo.TodoService;
import com.reactivetodo.service.todo.dto.request.CreateTodoRequest;
import com.reactivetodo.service.todo.dto.response.TodoInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class TodoController {

	private final TodoService todoService;

	@PostMapping("/api/v1/todo")
	public Mono<TodoInfoResponse> createTodo(@Valid @RequestBody CreateTodoRequest request) {
		return todoService.createTodo(request);
	}

	@GetMapping("/api/v1/todo/list")
	public Flux<TodoInfoResponse> getTodos() {
		return todoService.getTodos();
	}

}
