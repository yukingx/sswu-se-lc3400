// Document 클래스
public class Document {
    private String state;  // 상태를 나타내는 필드

    // 생성자
    public Document(String state) {
        this.state = state;
    }

    // publish 메서드 (상태 변경)
    public void publish(User currentUser) {
        switch (state) {
            case "draft":
                state = "moderation";
                break;

            case "moderation":
                if (currentUser.getRole().equals("admin")) {
                    state = "published";
                }
                break;

            case "published":
                // 이미 게시된 상태이므로 아무것도 하지 않음
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }

    // 상태를 출력하는 메서드
    public String getState() {
        return state;
    }

    // 상태를 변경하는 메서드
    public void setState(String state) {
        this.state = state;
    }

    // User 클래스를 정의하여 역할을 확인
    public static class User {
        private String role; // 사용자 역할

        public User(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

    // 메인 메서드에서 테스트
    public static void main(String[] args) {
        User user = new User("admin");
        Document document = new Document("draft");

        System.out.println("Initial State: " + document.getState());

        document.publish(user);
        System.out.println("After publish: " + document.getState());
    }
}
