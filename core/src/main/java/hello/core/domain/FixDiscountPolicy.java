package hello.core.domain;

import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
	private int discountFixAmount = 1000; //1000원 할인

	@Override
	public int discount(Member member, int itemPrice) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}
