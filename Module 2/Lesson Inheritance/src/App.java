public class App {
    public static void main(String[] args) {
        Person p = new Person("Merilee", "Sheldrick");
        Student s = new Student("Bale", "Packmann", "100-A29-WER");
        Instructor i = new Instructor("Letisha", "Pursey", "INS-COMPSCI-123", "Dr.");

        printPerson(p);
        printPerson(s);
        printPerson(i);

    }

    static void printPerson(Person p){
        if (p instanceof Person) {
            System.out.println("I'm a Person.");
        }
        if (p instanceof Student) {
            System.out.println("I'm a Student.");
            // cast the Person as a Student
            String studentId = ((Student) p).getStudentId();
            System.out.println("Student ID: " + studentId);
        }
        if (p instanceof Instructor) {
            System.out.println("I'm an Instructor.");
            // cast the Person as an Instructor
            String title = ((Instructor) p).getTitle();
            System.out.println("Title: " + title);
        }

        System.out.println("My name is: " + p.getFullName());
    }

}