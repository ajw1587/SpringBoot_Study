package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
    }

    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
        // bean.getClass() = class hello.core.AppConfig$$SpringCGLIB$$0
        // 순수한 class 라면 hello.core.AppConfig 까지만 출력이 되어야 한다.
        // 임의의 다른 클래스가 바로 싱글톤을 보장되도록 해준다.
        // 아마도 바이트 코드를 조작해서 작성되어 있을 것이다.

        // AppConfig@SpringCGLIB의 예상코드
        // @Bean
        // public MemberRepository memberRepository() {
        //   if (memoryMemberRepository가 이미 스프링 컨테이너에 등록되어 있으면?) {
        //         return 스프링 컨테이너에서 찾아서 반환;
        //   } else {
        //         기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록
        //         return 반환
        //   }

        // @Bean만 사용해도 되지만, 싱글톤은 보장되지 않는다.
    }
}
