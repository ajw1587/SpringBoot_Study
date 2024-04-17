package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")  // Bean 등록을 진행할때 자식 클래스도 다 가져와서 어떤 타입인지 파악을 하기 때문에 @Qualifier 로 타입을 명시해줄 수 있다.
// 자체 Annotation을 만든다면, @MainDiscountPolicy 를 사용하면 된다.
@Primary // 빈 등록에 있어서 우선 순위를 정해준다.
public class RateDiscountPolicy implements DiscountPolicy{

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
