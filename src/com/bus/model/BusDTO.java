/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bus.model;

import java.sql.Timestamp;

/**
 *
 * @author admin
 */
public class BusDTO {
    private int busno;
    private String start;
    private String end;
    private int price;
    private String grade;
    private Timestamp startDate;
    private String startTime;
    private int seatCount;
    
    public BusDTO(){
        
    }

    public BusDTO(int busno, String start, String end, int price, String grade, Timestamp startDate, String startTime, int seatCount) {
        this.busno = busno;
        this.start = start;
        this.end = end;
        this.price = price;
        this.grade = grade;
        this.startDate = startDate;
        this.startTime = startTime;
        this.seatCount = seatCount;
    }
    
    
    
    @Override
    public String toString() {
        return "BusDTO{" + "busno=" + busno + ", start=" + start + ", end=" + end + ", price=" + price + ", grade=" + grade + ", startDate=" + startDate + ", startTime=" + startTime + ", seatCount=" + seatCount + '}';
    }

    public int getBusno() {
        return busno;
    }

    public void setBusno(int busno) {
        this.busno = busno;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
    
}
