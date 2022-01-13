package hello.core.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import hello.core.domain.order.Order;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;

public class OrderServiceTest {

	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new OrderServiceImpl();

	@Test
	public void createOrder() throws Exception {
	    //given
	    Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

	    //when
		Order order = orderService.createOrder(memberId, "itemA", 10000);

	    //then
	    assertThat(order.getDiscountPrice()).isEqualTo(1000);
	 }
}
