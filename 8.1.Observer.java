import java.util.ArrayList;
import java.util.List;

// Observer 인터페이스
interface Observer {
    void update();
}

// Subject 클래스
class Subject {
    private List<Observer> observers = new ArrayList<>(); // 옵저버 목록

    // 옵저버 추가
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // 옵저버 제거
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // 모든 옵저버에게 알림
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// ConcreteSubject 클래스 (구체적인 주체)
class ConcreteSubject extends Subject {
    private String state; // 상태

    public String getState() {
        return state;
    }

    public void modifyState(String state) {
        this.state = state;
        notifyObservers(); // 상태 변경 시 옵저버들에게 알림
    }
}

// ConcreteObserver 클래스 (구체적인 옵저버)
class ConcreteObserver implements Observer {
    private String name;
    private ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println(name + " has been updated to new state: " + subject.getState());
    }
}

// Client 클래스 (옵저버와 주체 사용)
public class Client {
    public static void main(String[] args) {
        // ConcreteSubject 객체 생성
        ConcreteSubject subject = new ConcreteSubject();

        // ConcreteObserver 객체 생성 및 등록
        ConcreteObserver observer1 = new ConcreteObserver("Observer1", subject);
        ConcreteObserver observer2 = new ConcreteObserver("Observer2", subject);
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // 상태 변경 및 알림
        subject.modifyState("State1");
        subject.modifyState("State2");
    }
}
