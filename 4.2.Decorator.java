/* SE Week 10 - Decorator Pattern */
/* 집합 관계과 위임을 이용하여 데코레이터 패턴을 적용하여 기본 클래스 기능을 데코레이터 클래스에서 확장 */

// 기본 인터페이스
interface Component {
    void operation();
}

// 기본 구현 클래스
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Basic operation");
    }
}

// 데코레이터 클래스
class Decorator implements Component {
    private Component component;  // 기존 컴포넌트를 포함(집합 관계)

    // 생성자
    public Decorator(Component component) {
        this.component = component;  // 기존 객체를 데코레이터에 포함
    }

    @Override
    public void operation() {
        component.operation();  // 위임된 기존 객체의 메서드 호출
        addFeature();           // 추가 기능을 덧붙임
    }

    // 기능 추가
    private void addFeature() {
        System.out.println("Added feature");
    }
}

// 클라이언트 코드
public class Client {
    public static void main(String[] args) {
        // 기본 컴포넌트 생성
        Component component = new ConcreteComponent();
        
        // 데코레이터로 기능 확장
        Component decoratedComponent = new Decorator(component);

        // 데코레이터 적용 후 동작
        decoratedComponent.operation();
    }