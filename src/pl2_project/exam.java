/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2_project;

import java.util.Date;

/**
 *
 * @author amr atallah
 */
public class exam {

    private String questions;
    private String answers;
    private double grade;
    private int course_id;
    private String name;
    private int student_id;
    private String newexam;
    private String exam_date;
    private String duration;

    public exam(String name, double grade, int course_id, int student_id) {
        this.name = name;
        this.grade = grade;
        this.course_id = course_id;

        this.student_id = student_id;

    }

    public exam(String newexam, int course_id, String exam_date) {
        this.newexam = newexam;

        this.course_id = course_id;
        this.exam_date = exam_date;

    }

    public exam(int course_id, String questions, String answers, String duration) {
        this.course_id = course_id;
        this.questions = questions;
        this.answers = answers;
        this.duration = duration;

    }

    public void setNewExam(String newexam) {
        this.newexam = newexam;
    }

    public String getNewExam() {
        return newexam;

    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;

    }

    public void setExamDate(String exam_date) {
        this.exam_date = exam_date;
    }

    public String getExamDate() {
        return exam_date;

    }

    public void setQuestion(String questions) {
        this.questions = questions;

    }

    public String getQuestion() {
        return questions;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;

    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getanswers() {
        return answers;

    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

    public int getCourseId() {
        return course_id;

    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public int getStudentId() {
        return student_id;

    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public static int removeDuplicateElements(int arr[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];
        // Changing original array  
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        return j;
    }
    
}
