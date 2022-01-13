package hello.core.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.domain.Grade;
import hello.core.domain.Member;

public class MemberServiceTest {

	MemberService memberService = new MemberServiceImpl();

	@Test
	@DisplayName("join 테스트")
	public void join() throws Exception {
	    //given
	    Member member = new Member(1L, "memberA", Grade.VIP);
	    //when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);

	    //then
		assertThat(member).isEqualTo(findMember);

	 }
}
