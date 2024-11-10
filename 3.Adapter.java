/* SE Week 10 - Adapter Pattern */

// Target - InterfaceClientExpects.java
public interface InterfaceClientExpects {
    void expectedService();
}

// Adaptee - ServiceAvailable.java
public class ServiceAvailable {
    public void availableService() {
        System.out.println("ServiceAvailable의 availableService() 호출");
    }
}

// Adapter - Adapter.java
public class Adapter implements InterfaceClientExpects {
    private ServiceAvailable serviceAvailable;

    public Adapter(ServiceAvailable serviceAvailable) {
        this.serviceAvailable = serviceAvailable;
    }

    @Override
    public void expectedService() {
        serviceAvailable.availableService();
    }
}

// Client - Client.java
public class Client {
    public static void main(String[] args) {
        ServiceAvailable serviceAvailable = new ServiceAvailable();
        InterfaceClientExpects client = new Adapter(serviceAvailable);

        // ServiceAvailable의 availableService() 호출
        client.expectedService(); 
    }
}




// Target 인터페이스 - interfaceClientExpects
public interface Target {
    void request();
}

// Adaptee 클래스 - interfaceAvailable
public class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee의 specificRequest() 호출");
    }
}

// Adapter 클래스 - Adapter
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// 클라이언트 코드 - Client
public class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);

        target.request(); // Adaptee의 specificRequest() 호출
    }
}