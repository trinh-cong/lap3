package part3.exercise2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Add a list of students and save to file");
            System.out.println("2. Load list of students from file");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentsToFile();
                    break;
                case 2:
                    loadStudentsFromFile();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 3.");
            }
        } while (choice != 3);
    }

    private static void addStudentsToFile() {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        System.out.println("Enter student information (one student per line):");
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Mark: ");
            double mark = scanner.nextDouble();
            scanner.nextLine(); // consume newline character
            Student student = new Student(name, age, mark);
            studentList.add(student);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            for (Student student : studentList) {
                bufferedOutputStream.write((student.toString() + "\n").getBytes());
            }
            System.out.println("Student list added successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void loadStudentsFromFile() {
        List<Student> studentList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            Scanner scanner = new Scanner(bufferedInputStream);
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("\t");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                double mark = Double.parseDouble(tokens[2]);
                Student student = new Student(name, age, mark);
                studentList.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nList of all students:\n");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

}
