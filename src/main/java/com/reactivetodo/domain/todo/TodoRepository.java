package com.reactivetodo.domain.todo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TodoRepository extends ReactiveCrudRepository<Todo, String> {

	Mono<Todo> findById(String id);

}
