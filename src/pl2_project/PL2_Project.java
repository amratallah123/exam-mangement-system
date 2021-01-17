/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class PL2_Project {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        ArrayList<course> coursee = new ArrayList();
        ArrayList<user> userss = new ArrayList();
        ArrayList<exam> examm = new ArrayList();
        
        ArrayList<exam> examm3 = new ArrayList();
        
        exam examAns;
        user userr;
        course courses;
        course courses1 = new course();
        exam exaam;
        
        boolean access = false;
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=examsystem2;instance=MSSQLSERVER;encrypt=true;TrustServerCertificate=true;";
        String user = "amr";
        String pass = "123456789";
        int choise = -1;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            try {
                Statement myStmt = myConn.createStatement();

                try {

                    ResultSet myRs = myStmt.executeQuery("select * from users");
                    int myRs2;

                    while (myRs.next()) {

                        userr = new user(myRs.getInt("id"), myRs.getString("password"), myRs.getString("role"), myRs.getString("name"));
                        userss.add(userr);

                    }
                    myRs = myStmt.executeQuery("select * from examresult");
                    while (myRs.next()) {

                        exaam = new exam(myRs.getString("name"), myRs.getDouble("grade"), myRs.getInt("course_id"), myRs.getInt("student_id"));
                        examm.add(exaam);

                    }

                    String name;
                    String password;
                    int id;
                    int idNew;
                    String passwordNew;
                    int role = 0;
                    int k;
                    do {
                        System.out.println("enter your id:");
                        id = input.nextInt();
                        System.out.println("enter your password:");
                        password = input.next();

                        for (k = 0; k < userss.size(); k++) {
                            if (id == userss.get(k).getId() && password.equals(userss.get(k).getPassword())) {
                                if (userss.get(k).getRole().equals("admin")) {
                                    role = 1;
                                    break;
                                } else if (userss.get(k).getRole().equals("student")) {
                                    role = 2;
                                    break;
                                } else if (userss.get(k).getRole().equals("lecturer")) {
                                    role = 3;
                                    break;
                                }
                                break;
                            }
                        }

                        if (role == 0) {
                            System.out.println("The password or id that you've entered are incorrect. ");

                        }
                    } while (role == 0);

                    if (role == 1) {
                        while (choise != 0) {
                            System.out.println("Admin-" + userss.get(k).getName());
                            System.out.println("");

                            System.out.println("-----------------------Menue-----------------------\n");
                            System.out.println("1- insert a student   :              2- insert a lecturer    :");
                            System.out.println("3-delete a student    :              4-delete a lecturer     :");
                            System.out.println("5-update a student    :              6-update a lecturer     :");
                            System.out.println("7-search for a student:              8-search for a lecturer :");
                            System.out.println("9- insert an admin    :              10-update a admin       :");
                            System.out.println("11-delete an admin    :              12-search for an admin  :");
                            System.out.println("13- list of student   :              14- list of lecturer    :");
                            System.out.println("15- list of admin     :              16-list of grade student:");
                            System.out.println("17- list of course    :              18- set course          :");
                            System.out.println("0- to log out         :");
                            choise = input.nextInt();
                            input.nextLine();
                            if (choise == 1) {
                                System.out.print("enter his name: ");
                                name = input.nextLine();
                                System.out.print("enter his id(numbers only): ");
                                id = input.nextInt();
                                System.out.print("enter his password: ");
                                password = input.next();
                                myRs2 = myStmt.executeUpdate("insert into users values (" + id + ",'" + password + "','student','" + name + "')");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 2) {

                                System.out.print("enter his name: ");
                                name = input.nextLine();
                                System.out.print("enter his id(numbers only): ");
                                id = input.nextInt();
                                System.out.print("enter his password: ");
                                password = input.nextLine();
                                myRs2 = myStmt.executeUpdate("insert into users values (" + id + ",'" + password + "','lecturer','" + name + "')");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 3 || choise == 4 || choise == 11) {
                                System.out.print("enter his id");
                                id = input.nextInt();
                                myRs2 = myStmt.executeUpdate("delete from users where id=" + id);
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 5 || choise == 6 || choise == 10) {
                                boolean cond = false;
                                System.out.println("enter his id");
                                id = input.nextInt();
                                for (int i = 0; i < userss.size(); i++) {

                                    if (id == userss.get(i).getId()) {
                                        System.out.println("enter his new password");
                                        passwordNew = input.next();
                                        myRs2 = myStmt.executeUpdate("update users set password = '" + passwordNew + "' where id = " + id);
                                        cond = true;
                                        System.out.println("The operation is complete\n\n");
                                    }

                                }
                                if (cond == false) {
                                    System.out.println("you enter wrong id");
                                }
                            } else if (choise == 7 || choise == 8 || choise == 12) {
                                System.out.println("enter his id");
                                id = input.nextInt();
                                for (int i = 0; i < userss.size(); i++) {

                                    if (id == userss.get(i).getId()) {
                                        System.out.println(" is exist name is: " + userss.get(i).getName());
                                        System.out.println(" Role is: " + userss.get(i).getRole());
                                    }
                                }
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 9) {

                                System.out.print("enter his name: ");
                                name = input.nextLine();
                                System.out.print("enter his id(numbers only): ");
                                id = input.nextInt();
                                input.nextLine();
                                System.out.print("enter his password: ");
                                password = input.nextLine();
                                myRs2 = myStmt.executeUpdate("insert into users values('" + password + "','admin','" + name + "')");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 13) {
                                System.out.println("----------------------------------------------------");
                                System.out.printf("%-20s%-20s", "name", "id");
                                System.out.println();
                                System.out.println("----------------------------------------------------");
                                for (int i = 0; i < userss.size(); i++) {
                                    if (userss.get(i).getRole().equals("student")) {
                                        System.out.printf("%-20s%-20d\n", userss.get(i).getName(), userss.get(i).getId());
                                    }
                                }
                                System.out.println("----------------------------------------------------");
                                System.out.println("mession complete\\");
                            } else if (choise == 14) {
                                System.out.println("----------------------------------------------------");
                                System.out.printf("%20s%20s", "name", "id");
                                System.out.println();
                                System.out.println("----------------------------------------------------");
                                for (int i = 0; i < userss.size(); i++) {
                                    if (userss.get(i).getRole().equals("lecturer")) {
                                        System.out.printf("%20s%20d\n", userss.get(i).getName(), userss.get(i).getId());
                                    }
                                }
                                System.out.println("----------------------------------------------------");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 15) {
                                System.out.println("--------admin list---------");
                                System.out.printf("name                  id\n");
                                for (int i = 0; i < userss.size(); i++) {
                                    if (userss.get(i).getRole().equals("admin")) {
                                        System.out.printf("%s            %d\n", userss.get(i).getName(), userss.get(i).getId());
                                    }
                                }
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 16) {
                                System.out.println("---------student grade-------------");
                                System.out.println("--------------------------------------------------------------");
                                System.out.printf("%-20s%-20s%-20s%-20s", "name", "course_id", "student_id", "grade");
                                System.out.println("");
                                System.out.println("--------------------------------------------------------------");
                                for (int i = 0; i < examm.size(); i++) {
                                    System.out.printf("%-20s%-20d%-20d%-20f", examm.get(i).getName(), examm.get(i).getCourseId(), examm.get(i).getStudentId(), examm.get(i).getGrade());
                                    System.out.println("");
                                }
                                System.out.println("--------------------------------------------------------------");
                              System.out.println("The operation is complete\n\n");
                            } else if (choise == 17) {
                                myRs = myStmt.executeQuery("select * from course");
                                while (myRs.next()) {

                                    courses = new course(myRs.getString("name"), myRs.getInt("lecturer_id"), myRs.getInt("id"));
                                    coursee.add(courses);

                                }
                                System.out.println("---------------------Courses---------------------");
                                System.out.println("--------------------------------------------------------------");
                                System.out.printf("%-20s%-20s%-20s", "name", "course_id", "id");
                                System.out.println("");
                                System.out.println("--------------------------------------------------------------");
                                for (int i = 0; i < coursee.size(); i++) {
                                    System.out.printf("%-20s%-20d%-20d", coursee.get(i).getName(), coursee.get(i).getId(), coursee.get(i).getLecturerId());
                                    System.out.println("");
                                }
                                System.out.println("--------------------------------------------------------------");
                                System.out.println("mession complete\n\n");
                            }

                            if (choise == 18) {

                                System.out.println("enter course id ");
                                int examId = input.nextInt();
                                input.nextLine();
                                System.out.println("enter course name ");
                                name = input.nextLine();
                                myRs2 = myStmt.executeUpdate("insert into course values('" + name + "'," + id + "," + examId + ")");
                                System.out.println("The operation is complete\n\n");
                            }

                        }
                    } else if (role == 2) {
                        while (choise != 0) {
                            System.out.println("Dear Student-" + userss.get(k).getName());
                            System.out.println("\n-----------------------Menue-----------------------\n");
                            System.out.println("1- list your grades     :");
                            System.out.println("2- update your password :");
                            System.out.println("3- yours courses        :");
                            System.out.println("4- enter your exam      :");
                            System.out.println("5- exam answers         :");
                            System.out.println("0- to log out           :");
                            choise = input.nextInt();

                            if (choise == 1) {
                                System.out.println("----your grade-----");
                                System.out.println("---------------------------------------------------------------");
                                System.out.printf("%-20s%-20s%-20s%-20s", "name", "course_id", "id", "grade");
                                System.out.println("");
                                System.out.println("---------------------------------------------------------------");
                                for (int i = 0; i < examm.size(); i++) {
                                    if (examm.get(i).getStudentId() == id) {
                                        System.out.printf("%-20s%-20d%-20d%-20f", examm.get(i).getName(), examm.get(i).getCourseId(), examm.get(i).getStudentId(), examm.get(i).getGrade());
                                        System.out.println("");
                                    }
                                }
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 2) {
                                System.out.println("enter new password");
                                passwordNew = input.next();
                                myRs2 = myStmt.executeUpdate("update users set password = '" + passwordNew + "' where id = " + id);
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 3) {

                                ArrayList<String> myCourses = new ArrayList<>();
                                myRs = myStmt.executeQuery("select name from course,registercourse where student_id =" + id);

                                while (myRs.next()) {

                                    myCourses.add(myRs.getString("name"));

                                }
                                for (int j = 0; j < myCourses.size(); j++) {
                                    for (int i = 0; i < myCourses.size(); i++) {
                                        if (myCourses.get(i).equals(myCourses.get(j))) {
                                            myCourses.remove(i);

                                        }
                                    }
                                }
                                for (int j = 0; j < myCourses.size(); j++) {
                                    System.out.println(myCourses.get(j));
                                }
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 4) {
                                ArrayList<String> myCourses = new ArrayList<>();
                                myRs = myStmt.executeQuery("select name from course,registercourse where student_id =" + id);

                                while (myRs.next()) {

                                    myCourses.add(myRs.getString("name"));

                                }
                                input.nextLine();
                                System.out.println("enter course to access");
                                String Cname = input.nextLine();
                                access = courses1.accessCourse(myCourses, Cname, access);
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 5) {
                                myRs = myStmt.executeQuery("select course_id,questions,answers,duration from examanswers");
                                while (myRs.next()) {

                                    examAns = new exam(myRs.getInt("course_id"), myRs.getString("questions"), myRs.getString("answers"), myRs.getString("duration"));
                                    examm3.add(examAns);

                                }
                                System.out.println("---------------examxs answers--------------");
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                                System.out.printf("%-20s%-50s%-50s%-20s", "courseId", "questions", "answers", "duration");
                                System.out.println("");
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                                for (int i = 0; i < examm3.size(); i++) {

                                    System.out.printf("%-20s%-50s%-50s%-20s", examm3.get(i).getCourseId(), examm3.get(i).getQuestion(), examm3.get(i).getanswers(), examm3.get(i).getDuration());
                                    System.out.println("");
                                }
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("The operation is complete\n\n");
                            }
                        }

                    } else if (role == 3) {
                        while (choise != 0) {
                            System.out.println("Lecturere-" + userss.get(k).getName());
                            System.out.println("\n-----------------------Menue-----------------------\n");
                            System.out.println("1- Insert an exam : ");
                            System.out.println("2-report : ");
                            System.out.println("3-sum of grades : ");
                            System.out.println("4-set exam answers and duration:");
                            System.out.println("5-update your password:");
                            System.out.println("0- to log out :");
                            choise = input.nextInt();

                            if (choise == 1) {

                                System.out.println("enter course id to set exam");
                                int examId = input.nextInt();
                                input.nextLine();
                                System.out.println("enter course name to set exam");
                                name = input.nextLine();
                                myRs2 = myStmt.executeUpdate("insert into course values('" + name + "'," + id + "," + examId + ")");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 2) {
                                System.out.println("--------students grades---------------");
                                System.out.println("---------------------------------------------------------------------");
                                System.out.printf("%-20s%-20s%-20s%-20s", "name", "course_id", "student_id", "grade");
                                System.out.println("");
                                System.out.println("---------------------------------------------------------------------");
                                for (int i = 0; i < examm.size(); i++) {
                                    System.out.printf("%-20s%-20d%-20d%-20f",examm.get(i).getName(), examm.get(i).getCourseId(), examm.get(i).getStudentId(),examm.get(i).getGrade());
                                    System.out.println("");
                                }
                                System.out.println("---------------------------------------------------------------------");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 3) {
                                int length = examm.size();
                                int[] arr = new int[length];

                                for (int i = 0; i < examm.size(); i++) {
                                    arr[i] = examm.get(i).getStudentId();
                                }
                                length = exam.removeDuplicateElements(arr, length);
                                double[] sumGrade = new double[length];
                                for (int i = 0; i < length; i++) {
                                    myRs = myStmt.executeQuery("select sum(grade) as sum_score from examresult where student_id = " + arr[i]);

                                    while (myRs.next()) {
                                        sumGrade[i] = myRs.getDouble("sum_score");
                                    }
                                }
                                System.out.println("------sum Score--------------------");
                                System.out.println("-----------------------------------");
                                System.out.printf("%-20s%-20s", "sum_score", "id");
                                System.out.println("");
                                System.out.println("-----------------------------------");
                                for (int i = 0; i < length; i++) {

                                    System.out.printf("%-20f,%-20d",sumGrade[i], arr[i]);
                                    System.out.println("");
                                }
                                System.out.println("-----------------------------------");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 4) {

                                System.out.println("enter course id ");
                                int Cid = input.nextInt();
                                System.out.println("enter Questions like this {1,2,3,4,5....}");
                                input.nextLine();
                                String questions = input.nextLine();
                                System.out.println("enter anwsers in same order");
                                String answers = input.nextLine();
                                System.out.println("enter duration of exam");
                                String duration = input.nextLine();
                                myRs2 = myStmt.executeUpdate("insert into examanswers values(" + Cid + ",'" + questions + "','" + answers + "','" + duration + "')");
                                System.out.println("The operation is complete\n\n");
                            } else if (choise == 5) {
                                System.out.println("enter new password");
                                passwordNew = input.next();
                                myRs2 = myStmt.executeUpdate("update users set password = '" + passwordNew + "' where id = " + id);
                                System.out.println("The operation is complete\n\n");
                            }

                        }
                    }

                    System.out.println("The operation is complete\n\n");

                } catch (Exception e) {
                    System.out.println("Error with data entry ");
                }
            } catch (Exception e) {
                System.out.println("Error connecting to database");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
