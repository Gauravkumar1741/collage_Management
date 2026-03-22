package com.college;

import com.college.service.CollegeService;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        CollegeService service = new CollegeService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Add Student");
            System.out.println("2.Add Course");
            System.out.println("3.Add Faculty");
            System.out.println("4.Enroll Student");
            System.out.println("5.Assign Faculty");
            System.out.println("6.Fetch Students per Course");
            System.out.println("7.Fetch Courses by Faculty");
            System.out.println("8.Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    sc.nextLine();
                    service.addStudent(sc.nextLine());
                    break;

                case 2:
                    sc.nextLine();
                    service.addCourse(sc.nextLine());
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Faculty Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    service.addFaculty(name, dept);
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Course ID: ");
                    int cid = sc.nextInt();
                    service.enrollStudent(sid, cid);
                    break;

                case 5:
                    System.out.print("Faculty ID: ");
                    int fid = sc.nextInt();
                    System.out.print("Course ID: ");
                    cid = sc.nextInt();
                    service.assignFaculty(fid, cid);
                    break;

                case 6:
                    service.fetchStudentsPerCourse(sc.nextInt());
                    break;

                case 7:
                    service.fetchCoursesByFaculty(sc.nextInt());
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}