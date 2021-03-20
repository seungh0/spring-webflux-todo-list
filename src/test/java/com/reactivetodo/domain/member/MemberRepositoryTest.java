package com.reactivetodo.domain.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	void test() {
		// given
		Member member = memberRepository.save(Member.newInstance("will.seungho@gmail.com", "강승호"));

		// when
		Member member1 = memberRepository.findMemberById(member.getId());

		// then
		assertThat(member1.getEmail()).isEqualTo(member.getEmail());
	}

}
