
import java.util.Scanner;

public class Student {
    private int studentID;
    private String name;
    private String course;
    private static Student [] stud = new Student[10];
    private static int arrayCount = 0;
    private static int studentCount = 0;

    private static Scanner a = new Scanner(System.in);

    public Student(int studentID, String name, String course) {
        this.studentID = studentID;
        this.name = name;
        this.course = course;
        studentCount++;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getCourse(){
        return course;
    }

    public int getId(){
        return studentID;
    }
    
    public static int getStudCount(){
        return studentCount;
    }

    public void displayStudentInfo(){
        System.out.println();
        System.out.println("Student ID: " + this.studentID);
        System.out.println("Name: " + this.name);
        System.out.println("Course: " + this.course);
        System.out.println("--------------------------");
    }

    public static void menu(){
        while(true){
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student Info");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = a.nextInt();
            a.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudentInfo();
                    break;
                case 0:
                   exit();
                    return;
                default:
                   System.out.println("Invalid Input");
                   System.out.println("Choose between 0 t0 3");
                   break;
            }
        }
    }

    private static void addStudent(){

        System.out.print("Entet student id: ");
        int studId = a.nextInt();
        a.nextLine();

        System.out.print("Enter name: ");
        String name = a.nextLine();

        System.out.print("Enter course: ");
        String course = a.nextLine();

        stud[arrayCount] = new Student(studId, name, course);
        arrayCount++;

        System.out.println("Successfully Added New Name!");

        }

    private static void viewStudent(){
        if(studentCount == 0){
            System.out.println("No student registered!");
        }else{
            for(Student student: stud){
                if(student != null){
                    student.displayStudentInfo();
                }
            }
        }

        System.out.println("Total number of student: " + studentCount);
    }

    private static void updateStudentInfo(){
        System.out.print("Enter your student Id: ");
        int studID = a.nextInt();
        a.nextLine();

        Student found = null;
        for (Student student : stud){
            if(student.getId() == studID){
                found = student;
                break;
            }
        }        

        if(found == null){
            System.out.println("Your id " + studID + "not exist");
        }

        System.out.print("What info would you like to change? name/course ");
        String answer = a.nextLine();

        if(answer.equalsIgnoreCase("name")){
            System.out.print("Enter your new name: ");
            String newName = a.nextLine();

            found.setName(newName);

            System.out.println("Successfully Updated Name!");
        }else if(answer.equalsIgnoreCase("course")){
            System.out.print("Enter your new course");
            String newCourse = a.nextLine();

            found.setCourse(newCourse);

            System.out.println("Successfully Updated Course!");
        }else{
            System.out.println("Invalid input");
        }
    }

    private static void exit(){
        System.out.println("Okay Bye!");
        
    }
}
