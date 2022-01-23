package hello.core.service;

import hello.core.domain.discount.DiscountPolicy;
import hello.core.domain.member.Member;
import hello.core.domain.order.Order;
import hello.core.repository.MemberRepository;

public class OrderServiceImpl implements OrderService {
	// private MemberRepository memberRepository = new MemoryMemberRepository();
	private MemberRepository memberRepository;
	// private DiscountPolicy discountPolicy = new FixDiscountPolicy();
	// private DiscountPolicy discountPolicy = new RateDiscountPolicy(); //DIP, OCP 위반
	private DiscountPolicy discountPolicy; //NPE 발생. Interface 만으로는 할 수 없다. -> 누군가 Client 에 구현 객체를 대신 생성해서 주입해줘야 함

	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
