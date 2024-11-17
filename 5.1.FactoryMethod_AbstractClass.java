// AbstractSUV: 제품의 인터페이스 또는 추상 클래스
public abstract class AbstractSUV {
    public abstract void operation();
}

// ConcreteSUV: AbstractSUV를 구현한 실제 제품 클래스
public class ConcreteSUV extends AbstractSUV {
    @Override
    public void operation() {
        System.out.println("ConcreteProduct operation");
    }
}

// AbstractCreator: 팩토리 메서드를 정의하는 추상 클래스
public abstract class AbstractCreator {
    public abstract AbstractSUV createSUV();
}

// ConcreteCreator: 실제 ConcreteSUV를 생성하는 클래스
public class ConcreteCreator extends AbstractCreator {
    @Override
    public AbstractSUV createSUV() {
        return new ConcreteSUV();  // ConcreteProduct 객체 생성
    }
}

public class Client {
    public static void main(String[] args) {
        AbstractCreator creator = new ConcreteCreator();
        AbstractSUV suv = creator.createSUV(); // ConcreteSUV 객체가 생성됨
        suv.operation(); // ConcreteSUV의 operation() 메서드 호출
    }
}