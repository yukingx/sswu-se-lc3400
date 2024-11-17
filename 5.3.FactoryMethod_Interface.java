/* SE Week 11 - Factory Method Pattern */

// AbstractSUV: SUV 제품의 인터페이스
public interface AbstractSUV {
    void operation();
}

// ConcreteSUV1: 첫 번째 SUV 제품 클래스
public class ConcreteSUV1 implements AbstractSUV {
    @Override
    public void operation() {
        System.out.println("ConcreteSUV1 operation");
    }
}

// ConcreteSUV2: 두 번째 SUV 제품 클래스
public class ConcreteSUV2 implements AbstractSUV {
    @Override
    public void operation() {
        System.out.println("ConcreteSUV2 operation");
    }
}

// AbstractCreator: 팩토리 메서드를 정의하는 인터페이스
public interface AbstractCreator {
    AbstractSUV createSUV();
}

// ConcreteCreator1: 첫 번째 SUV 제품을 생성하는 팩토리 클래스
public class ConcreteCreator1 implements AbstractCreator {
    @Override
    public AbstractSUV createSUV() {
        return new ConcreteSUV1();  // ConcreteSUV1 객체 생성
    }
}

// ConcreteCreator2: 두 번째 SUV 제품을 생성하는 팩토리 클래스
public class ConcreteCreator2 implements AbstractCreator {
    @Override
    public AbstractSUV createSUV() {
        return new ConcreteSUV2();  // ConcreteSUV2 객체 생성
    }
}

public class Client {
    public static void main(String[] args) {
        // 첫 번째 SUV 제품을 생성하는 팩토리
        AbstractCreator creator1 = new ConcreteCreator1();
        AbstractSUV suv1 = creator1.createSUV(); // ConcreteSUV1 객체가 생성됨
        suv1.operation(); // ConcreteSUV1의 operation() 메서드 호출

        // 두 번째 SUV 제품을 생성하는 팩토리
        AbstractCreator creator2 = new ConcreteCreator2();
        AbstractSUV suv2 = creator2.createSUV(); // ConcreteSUV2 객체가 생성됨
        suv2.operation(); // ConcreteSUV2의 operation() 메서드 호출
    }
}
