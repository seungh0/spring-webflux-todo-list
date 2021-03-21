package com.reactivetodo.domain.member;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface MemberRepository extends ReactiveCrudRepository<Member, Long> {

	Mono<Member> findByEmail(String email);

}
