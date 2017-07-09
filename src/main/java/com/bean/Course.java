package com.bean;

/**
 * Created by des on 2017/7/8.
 * 实体类  课程
 */
public class Course {

    private int courseId;
    private String courseName;

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {

        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
