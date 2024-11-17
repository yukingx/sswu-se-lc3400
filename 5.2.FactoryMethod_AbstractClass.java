/* SE Week 11 - Factory Method Pattern */

// AbstractSUV: 제품의 추상 클래스
public abstract class AbstractSUV {
    public abstract void operation();
}

// ConcreteSUV1: AbstractSUV를 구현한 첫 번째 SUV 제품 클래스
public class ConcreteSUV1 extends AbstractSUV {
    @Override
    public void operation() {
        System.out.println("ConcreteSUV1 operation");
    }
}

// ConcreteSUV2: AbstractSUV를 구현한 두 번째 SUV 제품 클래스
public class ConcreteSUV2 extends AbstractSUV {
    @Override
    public void operation() {
        System.out.println("ConcreteSUV2 operation");
    }
}

// AbstractCreator: 팩토리 메서드를 정의하는 추상 클래스
public abstract class AbstractCreator {
    // 팩토리 메서드
    public abstract AbstractSUV createSUV();
}

// ConcreteCreator: 실제 SUV를 생성하는 팩토리 클래스
public class ConcreteCreator extends AbstractCreator {
    // SUV 종류를 선택하여 생성하는 메서드
    @Override
    public AbstractSUV createSUV() {
        // 두 개의 SUV 중 하나를 선택해서 반환
        if (someCondition()) {
            return new ConcreteSUV1();  // ConcreteSUV1 생성
        } else {
            return new ConcreteSUV2();  // ConcreteSUV2 생성
        }
    }

    // 예시: 조건에 따라 SUV의 종류를 결정하는 로직 (실제 상황에 맞게 수정)
    private boolean someCondition() {
        // 조건을 설정하여 어떤 SUV를 생성할지 결정
        return true;  // 임의로 ConcreteSUV1을 반환한다고 가정
    }
}

public class Client {
    public static void main(String[] args) {
        // 하나의 팩토리에서 두 가지 종류의 SUV를 생성 가능
        AbstractCreator creator = new ConcreteCreator();
        AbstractSUV suv = creator.createSUV(); // ConcreteSUV1 또는 ConcreteSUV2 객체 생성
        suv.operation(); // SUV의 operation() 메서드 호출
    }
}
