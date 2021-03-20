package com.reactivetodo.domain.member;

import com.reactivetodo.domain.member.repository.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
