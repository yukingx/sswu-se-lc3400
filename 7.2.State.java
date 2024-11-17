// State 인터페이스
public interface State {
    void doThis();
    void doThat();
}

// ConcreteState1: 첫 번째 상태
public class ConcreteState1 implements State {
    @Override
    public void doThis() {
        System.out.println("ConcreteState1 - doThis");
    }

    @Override
    public void doThat() {
        System.out.println("ConcreteState1 - doThat");
    }
}

// ConcreteState2: 두 번째 상태
public class ConcreteState2 implements State {
    @Override
    public void doThis() {
        System.out.println("ConcreteState2 - doThis");
    }

    @Override
    public void doThat() {
        System.out.println("ConcreteState2 - doThat");
    }
}

// Context: 상태를 관리하는 객체
public class Context {
    private State state;  // 현재 상태를 저장

    // 상태를 설정하는 메서드
    public void setContext(State state) {
        this.state = state;
    }

    // 현재 상태에 따른 행동을 실행하는 메서드
    public void doThis() {
        state.doThis();
    }

    public void doThat() {
        state.doThat();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        // 초기 상태 설정
        State state1 = new ConcreteState1();
        context.setContext(state1); // ConcreteState1 객체를 설정
        context.doThis();  // ConcreteState1 - doThis
        context.doThat();  // ConcreteState1 - doThat

        // 상태 변경
        State state2 = new ConcreteState2();
        context.setContext(state2); // ConcreteState2 객체를 설정
        context.doThis();  // ConcreteState2 - doThis
        context.doThat();  // ConcreteState2 - doThat
    }
}
