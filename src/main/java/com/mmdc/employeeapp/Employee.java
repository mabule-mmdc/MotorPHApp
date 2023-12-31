/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mmdc.employeeapp;

import java.util.ArrayList;

/**
 *
 * @author micahbule
 */
public class Employee {
    private String id;
    private String first_name;
    private String last_name;
    private float hourly_rate;
    private float basic_salary;
    private ArrayList<Attendance> time_records = new ArrayList<>();
    
    public Employee(String id, String firstName, String lastName, float hourlyRate, float basicSalary) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.hourly_rate = hourlyRate;
        this.basic_salary = basicSalary;
    }
    
    public float getBasicSalary() {
        return this.basic_salary;
    }
    
    public String getId() {
        return id;
    }
    
    public String getFullName() {
        return this.first_name + " " + this.last_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public float getHourlyRate() {
        return hourly_rate;
    }
    
    public void addTimeRecord(Attendance timeRecord) {
        this.time_records.add(timeRecord);
    }
    
    public int getTimeRecordsCount() {
        return this.time_records.size();
    }
    
    public int getMonthlyTotalHours(int monthNumber) {
        ArrayList<Attendance> filteredTimeRecords = new ArrayList<>();
        int monthlyTotalHours = 0;
        
        for (int index = 0; index < this.time_records.size(); index++) {
            Attendance timeRecord = this.time_records.get(index);
            
            if (timeRecord.getMonth() == monthNumber) {
                monthlyTotalHours += timeRecord.getHours();
            }
        }
        
        return monthlyTotalHours;
    }
    
    public float getMonthlyGrossSalary(int monthNumber) {
        int monthlyHours = this.getMonthlyTotalHours(monthNumber);
        return this.hourly_rate * monthlyHours;
    }
    
    public float getMonthlyNetSalary(int monthNumber) {
        float grossSalary = this.getMonthlyGrossSalary(monthNumber);
        float netSalary = 0;
        
        float philhealthContribution = Deductions.computePhilHealth(this.basic_salary);
        
        System.out.println("Philhealth is " + philhealthContribution);
        
        float pagibigContribution = Deductions.computePagIBIG(this.basic_salary);
        
        System.out.println("PAGIBIG is " + pagibigContribution);
        
        float sssContribution = Deductions.computeSSS(grossSalary);
        
        System.out.println("SSS is " + sssContribution);
        
        float totalContributions = philhealthContribution + pagibigContribution + sssContribution;
        
        System.out.println("Total contributions is " + totalContributions);
        
        float taxableIncome = grossSalary - totalContributions;
        
        System.out.println("Taxable income " + taxableIncome);
        
        float withholdingTax = Deductions.computeWithholdingTax(taxableIncome);
        
        System.out.println("Withholding tax is " + withholdingTax);
        
        netSalary = taxableIncome - withholdingTax;
        
        return netSalary;
    }
}
