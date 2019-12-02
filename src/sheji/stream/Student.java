package sheji.stream;


public class Student {

    private Integer id;

    private String username;

//    private String password;

    private Integer age;

    public Student(Integer id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
