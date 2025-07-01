// 1. 'extends' pulls all non-private members from Person into Student.
//INHERITANCE
public class Student extends Person{

    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Student(String firstName, String lastName, String studentId) {
        //2. call the constructor on the "super" (or parent) class
        super(firstName,lastName);
        this.studentId = studentId;
    }

    // 1. Override annotation isn't required, but is polite.
    @Override
    public String getFullName(){
        // 2. Call the parent's 'getFullName' method.
        String personFullName = super.getFullName();
        //append the student id to the person's full name
        return String.format("%s, ID: %s", personFullName, studentId);
    }
}

/*The Person class has only one constructor. It requires a first name and a last name.
There's no way to instantiate a Person without using the constructor.
So, all subclasses must execute the Person constructor to initialize the class.
In this case, Student provides one constructor that requires first name, last name, and a student ID.
Before the constructor can do anything else, it must execute the parent's constructor by using the super keyword.
The super keyword accesses members in the parent (or super) class.*/

/* COMPOSITION
Student.java
public class Student {

    // make studentId read-only by omitted the setter
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }
}
 */