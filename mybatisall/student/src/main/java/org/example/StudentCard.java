package org.example;

import java.util.Date;
public class StudentCard {
    private int id;
    private int studentId;
    private Date startDate;
    private Date endDate;
    /*省略setter和getter方法*/
    @Override
    public String toString() {
        return "StudentCard [id=" + id + ", studentId=" + studentId + "]";
    }
}