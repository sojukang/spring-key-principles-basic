package hello.core.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import hello.core.domain.discount.FixDiscountPolicy;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import hello.core.domain.order.Order;
import hello.core.repository.MemoryMemberRepository;

public class OrderServiceImplTest {

	@Test
	void creatOrder() {
		// OrderServiceImpl orderService = new OrderServiceImpl(); // GI 하면 final 때문에 compile error 발생
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));

		OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
