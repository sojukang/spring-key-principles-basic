package hello.core.domain.discount;

import hello.core.domain.discount.DiscountPolicy;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
	private int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}
	}
}
