package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// ComponentScan 은 "@Component" 뿐만 아니라 "@Controller", "@Service", "@Repository", "@Configuration" 들도
// Spring Bean 에 포함한다.
@Configuration
@ComponentScan(
        // 탐색할 패키지의 시작 위치를 지정한다.
        // basePackages = {"hello.core", "gello.sevice"} 와 같이 여러 시작 위치를 지정할 수 있다.
        basePackages = "hello.core.member",

        // basePackageClasses: 지정한 클래스의 패키지를 탐색 시작 위로 지정한다.
        basePackageClasses = AutoAppConfig.class,
        // basePackages, basePackageClasses 를 지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean("memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
