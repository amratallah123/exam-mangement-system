/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2_project;

import java.util.ArrayList;

/**
 *
 * @author amr atallah
 * @date December 2020
 */
public class course {

    private String name;
    private int id;
    private int lecturer_id;
    private int student_id;

    public course(String name, int lecturer_id, int id) {
        this.name = name;
        this.id = id;
        this.lecturer_id = lecturer_id;
        this.student_id = student_id;
    }

    public course() {

    }

    public void setName(String name) {
        this.name = name;

    }

    public int getStudentId() {
        return student_id;
    }

    public int getLecturerId() {
        return lecturer_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String name) {
        this.name = name;

    }

    public boolean accessCourse(ArrayList<String>courses, String Cname, boolean access) {
        int z = 0;
        if (!access) {
            for (int i = 0; i < courses.size() ; i++) {

                if (!Cname.equals(courses.get(i))) {

                    z++;
                }
            }
            if (z == courses.size()) {
                System.out.println("XXXX you not found in this courseXX\n");
            } else {
                System.out.println("you now in your exam\n\n");
            }
        } else {
            System.out.println("you entered your exam onece before\n\n");
        }
        access = true;
        return access;
    }
}
