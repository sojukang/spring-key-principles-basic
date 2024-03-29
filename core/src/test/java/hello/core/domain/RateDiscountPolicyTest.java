package hello.core.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.domain.discount.RateDiscountPolicy;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;

public class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다.")
	public void vip_o() throws Exception {
	    //given
		Member member = new Member(1L, "memberVIP", Grade.VIP);

	    //when
		int discount = discountPolicy.discount(member, 10000);

	    //then
		assertThat(discount).isEqualTo(1000);
	 }

	 @Test
	 @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
	 public void vip_x() throws Exception {
	     //given
		 Member member = new Member(2L, "memberBasic", Grade.BASIC);
		 //when
		 int discount = discountPolicy.discount(member, 10000);
		 //then
		 assertThat(discount).isEqualTo(0);
	  }
}
