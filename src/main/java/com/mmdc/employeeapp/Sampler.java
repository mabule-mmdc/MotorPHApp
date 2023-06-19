/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mmdc.employeeapp;

import static java.lang.Float.parseFloat;
import java.util.Scanner;

/**
 *
 * @author micahbule
 */
public class Sampler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String grossSalaryString = scanner.nextLine();
        System.out.println("Deducted amount is " + Deductions.deductSSS(parseFloat(grossSalaryString)));
    }
}
