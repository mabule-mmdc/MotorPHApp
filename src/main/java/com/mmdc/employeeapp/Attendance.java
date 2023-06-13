/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mmdc.employeeapp;

import static java.lang.Integer.parseInt;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 *
 * @author micahbule
 */
public class Attendance {
    private LocalDateTime time_in;
    private LocalDateTime time_out;
    
    public Attendance(Date timeIn, Date timeOut) {
        this.time_in = timeIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.time_out = timeOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    public LocalDateTime getTimeIn() {
        return this.time_in;
    }
    
    public int getMonth() {
        return this.time_in.getMonthValue();
    }
    
    public int getHours() {
        return this.time_out.getHour() - this.time_in.getHour();
    }
}
