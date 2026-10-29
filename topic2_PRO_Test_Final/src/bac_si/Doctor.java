/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bac_si;

import Role.Role;
import java.util.Scanner;
import thuc_thi.Execute;

/**
 *
 * @author DUONG NGOC AN
 */
public class Doctor extends Role {

    private String doctorName = null;
    private String final_diagnosis = null;
    private String department = null;
    private Execute exec;

    public Doctor(Execute exec) {
        super("Bac si");
        this.exec = exec;
    }

  

    public void printDoctorInfo() {
        System.out.println("Ten bac si kham la: " + getDoctorName());
    }

    @Override
    public void showMenu(Scanner sc) {
        boolean it = true;
        while (it) {

            System.out.println("\n==================================");
            System.out.println("1. Xem danh sach benh nhan cho kham ");
            System.out.println("2. Chan doan ");
            System.out.println("0. Log out");
            System.out.println("==================================");
            int choice = exec.readInt("Hay nhap lua chon chuc nang: ");
            switch (choice) {
                case 1:
                    exec.showWaitingList();
                    break;
                case 2:
                    exec.examinePatient(this); 
                    break;
                case 0:
                    System.out.println("CAM ON BAN DA SU DUNG DICH VU!!!");
                    it = false;
                    break;
                default:
                    System.out.println("HAY CHON LAI!!!");
                    break;
            }
        }

    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        if (doctorName == null || doctorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }
        this.doctorName = doctorName.trim();
    }

    public String getFinal_diagnosis() {
        return final_diagnosis;
    }

    public void setFinal_diagnosis(String final_diagnosis) {
        if (final_diagnosis == null || final_diagnosis.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }
        this.final_diagnosis = final_diagnosis.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }
        this.department = department.trim();
    }

}