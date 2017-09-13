package javaconsole.entity;

public class Student {


    private int id;
    private String name;
    private String email;
    private String rollnumber;
    private String className;
    private String status;
    public Student() {

    }

    public Student(int id, String name, String email, String rollnumber, String className, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollnumber = rollnumber;
        this.className = className;
        this.status = status;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
