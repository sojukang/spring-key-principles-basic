package hello.core.domain.discount;

import org.springframework.stereotype.Component;

import hello.core.domain.discount.DiscountPolicy;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;

@Component
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
