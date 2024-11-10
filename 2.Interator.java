/* SE Week 10 - Iterator Pattern */

// Iterator 인터페이스
public interface Iterator {
    Object getFirst();   // 첫 번째 요소 반환
    Object getNext();    // 다음 요소 반환
    boolean hasNext();   // 더 이상 요소가 있는지 확인
}

// ConcreteIterator 구현
public class ConcreteIterator implements Iterator {
    private List<String> collection;
    private int index = 0;

    public ConcreteIterator(List<String> collection) {
        this.collection = collection;
    }

    @Override
    public Object getFirst() {
        return collection.get(0); // 첫 번째 요소 반환
    }

    @Override
    public Object getNext() {
        if (hasNext()) {
            return collection.get(index++);  // 다음 요소 반환
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size(); // 더 이상 요소가 있는지 확인
    }
}

// Aggregate 인터페이스
public interface Aggregate {
    Iterator createIterator();  // 반복자 생성
}

// ConcreteAggregate 구현
public class ConcreteAggregate implements Aggregate {
    private List<String> items;

    public ConcreteAggregate(List<String> items) {
        this.items = items;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items); // 반복자 반환
    }
}

/*  
 * Client
 * 
 * Result
 * First item: Item 1
 * Next item: Item 1
 * Next item: Item 2
 * Next item: Item 3
 * Next item: Item 4
*/
public class Client {
    public static void main(String[] args) {
        // 컬렉션에 데이터 추가
        List<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");

        // 집합체 객체 생성
        ConcreteAggregate aggregate = new ConcreteAggregate(items);

        // 반복자 생성
        Iterator iterator = aggregate.createIterator();

        // 첫 번째 요소 출력
        System.out.println("First item: " + iterator.getFirst());

        // 반복자를 통해 집합체의 나머지 요소 탐색
        while (iterator.hasNext()) {
            System.out.println("Next item: " + iterator.getNext());
        }
    }
}


