package student_management_System;

import java.util.Scanner;

// Base class
class Person {
    String name;
    int age;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Derived class - Inheritance
class Student extends Person {
    int rollNo;
    double marks;

    // Constructor Overloading
    public Student() {
        super();
        this.rollNo = 0;
        this.marks = 0.0;
    }

    public Student(String name, int age, int rollNo, double marks) {
        super(name, age);
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Method Overriding
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade(marks));
    }

    // Method Overloading
    public String calculateGrade(double marks) {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    public String calculateGrade(int theoryMarks, int practicalMarks) {
        double avg = (theoryMarks + practicalMarks) / 2.0;
        return calculateGrade(avg);
    }
}

// Main class
public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Grade with Theory & Practical");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();

                    students[count++] = new Student(name, age, roll, marks);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No students to display.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("\nStudent #" + (i + 1));
                            students[i].displayInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter theory marks: ");
                    int theory = sc.nextInt();
                    System.out.print("Enter practical marks: ");
                    int practical = sc.nextInt();
                    Student temp = new Student();
                    String grade = temp.calculateGrade(theory, practical);
                    System.out.println("Calculated Grade: " + grade);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
