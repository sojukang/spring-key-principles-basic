package hello.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.domain.discount.DiscountPolicy;
import hello.core.domain.member.Member;
import hello.core.domain.order.Order;
import hello.core.repository.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
	// private MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;
	// private DiscountPolicy discountPolicy = new FixDiscountPolicy();
	// private DiscountPolicy discountPolicy = new RateDiscountPolicy(); //DIP, OCP 위반
	private final DiscountPolicy discountPolicy; //NPE 발생. Interface 만으로는 할 수 없다. -> 누군가 Client 에 구현 객체를 대신 생성해서 주입해줘야 함

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	// Setter DI 사용 test를 위한 코드
	// @Autowired
	// public void setMemberRepository(MemberRepository memberRepository) {
	// 	this.memberRepository = memberRepository;
	// }
	//
	// @Autowired
	// public void setDiscountPolicy(DiscountPolicy discountPolicy) {
	// 	this.discountPolicy = discountPolicy;
	// }

	// 일반 메서드를 통한 주입도 가능하나 거의 사용하지 않는다.
	// @Autowired
	// public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
	// 	this.memberRepository = memberRepository;
	// 	this.discountPolicy = discountPolicy;
	// }

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
