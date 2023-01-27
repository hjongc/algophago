public class UserManager {
    private int size;
    private final int MAX_SIZE = 100;
    private User[] userList = new User[MAX_SIZE];

    // User타입의 변수를 배열에 추가하는 함수
    // 배열의 index에 변수를 할당하고 index를 하나씩 늘려 겹치지 않도록 함
    public void add(User user){
        userList[this.size] = user;
        this.size++;
    }

    // userList를 반환하는 함수, UserList는 size까지 정보가 담겨져 있기 때문에
    // 해당 index까지의 정보들을 담고있는 tmp배열을 새로 만들어 리턴
    public User[] getList(){
        User[] tmp = new User[this.size];
        for(int i = 0; i<size; i++){
            tmp[i] = this.userList[i];
        }
        return tmp;
    }

    // 이름으로 User 정보를 찾는 함수, 없다면 null 반환
    public User searchByName(String name){
        for(int i = 0; i<size; i++){
            if (this.userList[i].getName().equals(name)) return this.userList[i];
        }
        System.out.println("No such user");
        return null;
    }
}
