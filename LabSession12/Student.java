public class Student {
    private String id;
    private String name;
    private String email;
    private String course;
    private int age;

    public Student(String id, String name, String email, String course, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email + 
               ", Course: " + course + ", Age: " + age;
    }
}