/* SE Week 11 - Abstract Factory Pattern */

// 미디어 추상 클래스 (CD와 LP)
abstract class Media {
    public abstract void play();
}

// Concrete Media 1: CD
class CD extends Media {
    @Override
    public void play() {
        System.out.println("Playing a CD...");
    }
}

// Concrete Media 2: LP
class LP extends Media {
    @Override
    public void play() {
        System.out.println("Playing an LP...");
    }
}

// 플레이어 추상 클래스 (CD 플레이어, LP 플레이어)
abstract class Player {
    public abstract void playMedia();
}

// Concrete Player 1: CD 플레이어
class CDPlayer extends Player {
    @Override
    public void playMedia() {
        System.out.println("Playing media on the CD player...");
    }
}

// Concrete Player 2: LP 플레이어
class LPPlayer extends Player {
    @Override
    public void playMedia() {
        System.out.println("Playing media on the LP player...");
    }
}

// 미디어와 플레이어를 생성하는 추상 팩토리
abstract class MediaFactory {
    public abstract Media createMedia();
    public abstract Player createPlayer();
}

// ConcreteFactory 1: CD와 CD 플레이어를 생성하는 팩토리
class CDFactory extends MediaFactory {
    @Override
    public Media createMedia() {
        return new CD();
    }

    @Override
    public Player createPlayer() {
        return new CDPlayer();
    }
}

// ConcreteFactory 2: LP와 LP 플레이어를 생성하는 팩토리
class LPFactory extends MediaFactory {
    @Override
    public Media createMedia() {
        return new LP();
    }

    @Override
    public Player createPlayer() {
        return new LPPlayer();
    }
}

// Client: 팩토리를 사용하여 객체 생성
public class Client {
    public static void main(String[] args) {
        // CD 팩토리 생성
        MediaFactory cdFactory = new CDFactory();
        Media cd = cdFactory.createMedia();
        Player cdPlayer = cdFactory.createPlayer();

        cd.play();  // CD 재생
        cdPlayer.playMedia();  // CD 플레이어에서 재생

        // LP 팩토리 생성
        MediaFactory lpFactory = new LPFactory();
        Media lp = lpFactory.createMedia();
        Player lpPlayer = lpFactory.createPlayer();

        lp.play();  // LP 재생
        lpPlayer.playMedia();  // LP 플레이어에서 재생
    }
}
