/* SE Week 10 - Decorator Pattern */
/* 조금 더 현실적인 비즈니스 로직에서 데코레이터 패턴 사용 예 */

// Component
public abstract class Beverage {
    public abstract String getDescription();
    public abstract double cost();
}

// ConcreteComponent
public class Espresso extends Beverage {
    @Override
    public String getDescription() {
        return "에스프레소";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

// Decorator
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

// ConcreteDecorator
public class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 우유";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}

public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 휘핑크림";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new Espresso();
        beverage2 = new Milk(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}