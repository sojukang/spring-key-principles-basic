package hello.core.singleton;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.repository.MemberRepository;
import hello.core.service.MemberServiceImpl;
import hello.core.service.OrderServiceImpl;

public class ConfigurationSingletonTest {

	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class); //원래는 구체 타입으로 꺼내지 말자
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();

		System.out.println("memberService -> memberRepository1 = " + memberRepository1);
		System.out.println("orderService -> memberRepository2 = " + memberRepository2);
		System.out.println("memberRepository = " + memberRepository);

		assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}

	@Test
	void configurationDeep() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig bean = ac.getBean(AppConfig.class);

		System.out.println("bean = " + bean.getClass());
	}
}
