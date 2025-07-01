//INHERITANCE
public class Instructor extends Person{

    private String employeeId;
    private String title;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getFullName() {
        String personFullName = super.getFullName();
        //prepend the title to the person's full name
        return String.format("%s %s", title, personFullName);
    }

    public Instructor(String firstName, String lastName, String employeeId, String title) {
        super(firstName, lastName); //satisfy the parent constructor requirements
        this.employeeId = employeeId;
        this.title = title;
    }
}

/* COMPOSITION
Instructor.java
public class Instructor {

    // employeeId and title are read-only
    private String employeeId;
    private String title;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getTitle() {
        return title;
    }

    public Instructor(String employeeId, String title) {
        this.employeeId = employeeId;
        this.title = title;
    }
}
 */
