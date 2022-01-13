package hello.core.domain;

import hello.core.domain.member.Member;

public interface DiscountPolicy {
	int discount(Member member, int itemPrice);
}
