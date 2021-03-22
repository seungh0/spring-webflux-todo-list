package com.reactivetodo.domain.todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class TodoRepositoryTest {

	@Autowired
	private TodoRepository todoRepository;

	@AfterEach
	void cleanUp() {
		todoRepository.deleteAll();
	}

	@Test
	void save_test() {
		// given
		String title = "지짜";

		// when
		Mono<Todo> todoMono = todoRepository.save(new Todo(title));

		// then
		StepVerifier.create(todoMono)
				.assertNext(todo -> Assertions.assertEquals(todo.getTitle(), title))
				.verifyComplete();
	}

}
