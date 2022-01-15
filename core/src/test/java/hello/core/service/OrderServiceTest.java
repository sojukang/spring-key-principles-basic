package hello.core.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.domain.order.Order;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;

public class OrderServiceTest {

	// MemberService memberService = new MemberServiceImpl();
	// OrderService orderService = new OrderServiceImpl();
	MemberService memberService;
	OrderService orderService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	public void createOrder() throws Exception {
	    //given
	    Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

	    //when
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		Order order2 = orderService.createOrder(memberId, "itemA", 20000);

	    //then
	    assertThat(order.getDiscountPrice()).isEqualTo(1000);
	    assertThat(order2.getDiscountPrice()).isEqualTo(2000);
	}
}
