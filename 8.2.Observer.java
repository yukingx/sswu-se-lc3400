/* SE Week 11 - Observer Pattern */

// 옵저버 인터페이스
interface Observer {
    void update(String message);
}

// 주제(Subject) 인터페이스
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 구체적인 주제
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    // 뉴스 발행
    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

// 구체적인 옵저버
class NewsReader implements Observer {
    private String name;

    public NewsReader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}

// 클라이언트 코드
public class Client {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        
        // 옵저버 등록
        Observer reader1 = new NewsReader("Reader1");
        Observer reader2 = new NewsReader("Reader2");
        
        newsAgency.addObserver(reader1);
        newsAgency.addObserver(reader2);
        
        // 뉴스 발행
        newsAgency.setNews("Breaking News: Java Patterns are Awesome!");
        
        // 뉴스 변경
        newsAgency.setNews("New Update: Observer Pattern Explained!");
    }
}
