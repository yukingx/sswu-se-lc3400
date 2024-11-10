/* SE Week 10 - Singleton Pattern */

public class Singleton {
    // 유일한 인스턴스를 저장할 정적 변수
    private static Singleton instance;

    // private 생성자를 통해 외부에서 인스턴스를 생성하지 못하게 한다.
    private Singleton() {
        // 초기화 작업이 필요한 경우 여기에 작성
    }

    // 인스턴스를 반환하는 정적 메서드
    public synchronized static Singleton instance() {
        // 인스턴스가 아직 생성되지 않았다면, 새로 생성
        if (instance == null) {
            instance = new Singleton();
        }
        // 이미 인스턴스가 존재하면 기존의 인스턴스를 반환
        return instance;
    }
}

public static void main(String[] args) {
    // Singleton 패턴을 통해 인스턴스를 얻는다
    Singleton singleton1 = Singleton.instance();
            
    // 동일한 인스턴스를 다시 얻는다
    Singleton singleton2 = Singleton.instance();

    // 두 인스턴스가 동일한지 확인 (같은 인스턴스를 참조해야 한다)
    if (singleton1 == singleton2) {
        System.out.println("Both variables contain the same Singleton instance.");
    } 
    else {
            System.out.println("The instances are different.");
    }
}