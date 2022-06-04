package StudentManagement;


import StudentManagement.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        //TODO Auto-generated method stub
        //Create a collection object to store student data
        ArrayList<Student> array = new ArrayList<Student>();

        //Use the loop to complete and return to the main interface again
        while(true) {
            //Use the output statement to complete the writing of the main interface
            System.out.println("--------Welcome to the student management system--------");
            System.out.println("1 Add student");
            System.out.println("2 Delete student");
            System.out.println("3 modify students");
            System.out.println("4 View all students");
            System.out.println("5 Exit");
            System.out.println("Please enter your choice:");

            //Use Scanner to realize keyboard input data
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //Use the switch statement to complete the operation selection
            switch (line) {
                case "1":
                    System.out.println("Add Student");
                    addStudent(array);
                    break;
                case "2":
                    System.out.println("Delete Student");
                    deleteStudent(array);
                    break;
                case "3":
                    System.out.println("Modify Student");
                    updateStudent(array);
                    break;
                case "4":
                    System.out.println("View all students");
                    findStudent(array);
                    break;
                case "5":
                    System.out.println("Thank you for using");
                    //break;
                    System.exit(0);//JVM exits the program normally

                default:
                    System.out.println("Re-output");
                    break;
            }
        }
    }

    //Method is used to add student information
    public static void addStudent(ArrayList<Student> array) {
        //Keyboard input the data information needed by the student object, display prompt informatics, and prompt what kind of information to enter
        Scanner sc = new Scanner(System.in);

        //In order to allow sid to be accessed outside the while loop, we define it outside the loop
        String sid;

        //In order to prevent the repetition of the student number, you can directly enter the student number again and add a while loop
        while(true) {
            System.out.println("Enter student ID");
            //String sid = sc.nextLine();//Method variable
            sid = sc.nextLine();
            //Determine whether the student ID is repeated
            boolean flag = isUsed(array, sid);
            if (flag == false) {
                break;
            } else {
                System.out.println("Duplicate student ID, re-enter");
            }
        }

        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter age");
        String age = sc.nextLine();
        System.out.println("Enter the place of residence");
        String address = sc.nextLine();

        //Create a student object and assign the student information entered by the keyboard to the member variable of the student object
        Student s1 = new Student();
        s1.setSid(sid);
        s1.setAge(age);
        s1.setName(name);
        s1.setAddress(address);

        //Add the student object to the collection
        array.add(s1);

        //Give a hint that the addition is successful
        System.out.println("Successfully added students");

    }

    //Define a method to view student information
    public static void findStudent(ArrayList<Student> array) {
        if(array.size() == 0) {
            System.out.println("No information, please add information first!");
            //In order not to let the program execute down, give return;
            return;
        }
        //Display header information
        //\t is actually the position of the tab key
        System.out.println("student ID\t\tname\tage\tplace of residence");
        //Take out the data in the collection, display student information in the corresponding format, and add "years" to the age display
        for(int i=0; i<array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
        }
    }

    //Define a method to delete student information
    public static void deleteStudent(ArrayList<Student> array) {
        //Key in the student ID to be deleted and display the prompt message
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student ID of the student to be deleted:");
        String sid = sc.nextLine();

        //Traverse the collection and delete the student information corresponding to the student number in the collection
        //Before deleting/modifying the student operation, judge whether the student ID exists
        //If it does not exist, display a prompt message
        //If it exists, execute delete/modify operation
        int index = -1;//Identify whether student information exists
        for(int i=0; i<array.size(); i++) {
            Student s = array.get(i);
            if(s.getSid().equals(sid)) {
                index = i;
                break;
            }

        }
        if(index == -1) {
            System.out.println("The information does not exist, please re-enter!");
        }else{
            array.remove(index);
        }
        //Prompt for successful deletion
        System.out.println("Successful deletion of students!");

    }

    //Define a method to modify student information
    public static void updateStudent(ArrayList<Student> array) {
        //Key in the student ID to be modified, and display the prompt message
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student ID of the student you want to modify:");
        String sid = sc.nextLine();

        //Keyboard input to modify the student's information
        System.out.println("Enter the name of the student to be modified:");
        String name = sc.nextLine();
        System.out.println("Enter the age of the student to be modified:");
        String age = sc.nextLine();
        System.out.println("Enter the address of the student to be modified:");
        String address = sc.nextLine();

        //Create student objects (encapsulate these student information into a new student object)
        Student s = new Student();
        s.setAge(age);
        s.setName(name);
        s.setSid(sid);
        s.setAddress(address);//Created a new student object s

        int index = -1;
        //Traverse the collection to modify the corresponding student information
        //Before deleting/modifying the student operation, judge whether the student ID exists
        //If it does not exist, display a prompt message
        //If it exists, execute delete/modify operation
        for(int i=0; i<array.size(); i++) {
            Student student = array.get(i);
            if(student.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("Student information does not exist, please re-enter!");
        }else {
            array.set(index, s);//Modify the element at the corresponding position in the set (student object)
        }
        //Prompt message of successful modification
        System.out.println("Modify student information successfully!");
    }

    //Define a method to determine whether the student ID is occupied
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        //If the student ID is the same as a student in the set, return false, otherwise return true
        boolean flag =false;

        for(int i=0; i<array.size(); i++) {//traverse to find the student number
            Student student = array.get(i);
            if(student.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
