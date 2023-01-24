public class UserTest {
    public static void main(String[] args) {
        // 기본 생성자로 user1 생성
        User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김싸피");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);
        // 인자를 받는 생성자로 user2 생성
		User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);

        // usermanager 생성 후 user1,2를 배열에 add함
        UserManager um = new UserManager();
        um.add(user1);
        um.add(user2);

        // getList와 toString을 통해 등록된 사용자 리스트 출력
        User[] list_of_users = um.getList();
        for (int i = 0; i<list_of_users.length; i++){
            System.out.println(list_of_users[i].toString());
        }
        System.out.println("----------------");
        
        // "김싸피"라는 이름을 가진 사용자가 있으면 찾아서 출력
        System.out.println("이름으로 찾기 : "+um.searchByName("김싸피"));

        // 등록된 사용자 수 출력
        System.out.println("등록된 사용자 수 : "+um.getList().length);
    }
}
