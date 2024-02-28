package hello.core.singleton;

public class SingletonService {

    // Eager Initialization Singleton 방식의 싱글톤 클래스 생성방법
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // private으로 생성자를 외부에서 호출하지 못하게 만든다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
