/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mmdc.employeeapp;

/**
 *
 * @author micahbule
 */
public class Deductions {
    public static float deductSSS(float grossSalary) {
        float startSalaryRange = 3250;
        float contribution = 135;
        
        if (grossSalary < 3250) {
            return grossSalary - contribution;
        } else if (grossSalary >= 24750) {
            contribution = 1125;
            return grossSalary - contribution;
        } else {
            while (true) {
                float endSalaryRange = startSalaryRange + 500;
                contribution += 22.5;
            
                if (grossSalary >= startSalaryRange && grossSalary < endSalaryRange) {
                    return grossSalary - contribution;
                } else {
                    startSalaryRange = endSalaryRange;
                }
            }
        }
    }
}
