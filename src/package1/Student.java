package package1;

public class Student {
    private int id;
    private String name;
    private String dept;
    private int age;

    public Student(int id, String name, String dept, int age) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public int getAge() { return age; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDept(String dept) { this.dept = dept; }
    public void setAge(int age) { this.age = age; }
}
