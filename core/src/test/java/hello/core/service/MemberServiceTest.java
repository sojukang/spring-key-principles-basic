package hello.core.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;

public class MemberServiceTest {

	// MemberService memberService = new MemberServiceImpl();
	MemberService memberService;
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}

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
