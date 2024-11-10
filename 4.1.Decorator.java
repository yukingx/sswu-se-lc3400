/* SE Week 10 - Decorator Pattern */

// Component 인터페이스
interface Component {
    void operation();
}

// Component1: Component 인터페이스 구현
class Component1 implements Component {
    @Override
    public void operation() {
        System.out.println("Operation in Component1");
    }
}

// Decorator 클래스: Component 인터페이스를 구현하고 기존 기능에 추가 기능을 더함
abstract class Decorator implements Component {
    protected Component component;  // 집합 관계: 기존 객체를 포함

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();  // 기존 객체의 operation 메서드 호출 (위임 관계)
    }
}

// Decorator1: 추가 기능을 덧붙임
class Decorator1 extends Decorator {
    public Decorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();  // 기존 기능 호출
        addBehavior();  // 추가적인 기능 수행
    }

    private void addBehavior() {
        System.out.println("Adding behavior in Decorator1");
    }
}

// Decorator2: 또 다른 추가 기능을 덧붙임
class Decorator2 extends Decorator {
    public Decorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();  // 기존 기능 호출
        addBehavior();  // 추가적인 기능 수행
    }

    private void addBehavior() {
        System.out.println("Adding behavior in Decorator2");
    }
}

// Client 클래스: Decorator 패턴을 사용하는 곳
public class Client {
    public static void main(String[] args) {
        // 기본 객체 생성
        Component component = new Component1();

        // 첫 번째 데코레이터 적용
        Component decoratedComponent1 = new Decorator1(component);

        // 두 번째 데코레이터 적용
        Component decoratedComponent2 = new Decorator2(decoratedComponent1);

        // 데코레이터 적용 후 동작
        System.out.println("Operation with two decorators:");
        decoratedComponent2.operation();
    }
}
