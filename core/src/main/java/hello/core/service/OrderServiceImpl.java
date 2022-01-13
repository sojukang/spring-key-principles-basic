package hello.core.service;

import hello.core.domain.discount.DiscountPolicy;
import hello.core.domain.discount.FixDiscountPolicy;
import hello.core.domain.order.Order;
import hello.core.domain.member.Member;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	private MemberRepository memberRepository = new MemoryMemberRepository();
	private DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
