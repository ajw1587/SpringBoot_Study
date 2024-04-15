package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Lombok 은 @Getter, @Setter, @ToString 등을 제공한다.
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfas");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
