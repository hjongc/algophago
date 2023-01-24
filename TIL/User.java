public class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private int age;
    // 기본생성자
    public User(){}
    // 인자를 받는 생성자
    public User(String id, String password, String name, String email, int age){
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    // private 변수에 접근하기 위한 getter, setter 
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // 정보를 문자열로 출력하는 toString 함수를 오버라이드
    @Override
    public String toString() {
        return "[id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
                + "]";
    }
    
    
}
