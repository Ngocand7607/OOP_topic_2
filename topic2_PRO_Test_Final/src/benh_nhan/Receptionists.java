/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package benh_nhan;

import Role.Role;
import java.util.Scanner;
import thuc_thi.Execute;

/**
 *
 * @author DUONG NGOC AN
 */
public class Receptionists extends Role {

    private String name;
    private String bday;
    private String gender;
    private String sickness;
    private String priority;
    private int ticketNumber;
    private Execute exec;

    public Receptionists() {
        super("Le tan");
    }

    public Receptionists(Execute exec) {
        super("Le tan");
        this.exec = exec;
    }

    public Receptionists(String name, String bday, String gender, String sickness, String priority) {
        super("Le tan");
        this.name = name;
        this.bday = bday;
        this.gender = gender;
        this.sickness = sickness;
        this.priority = priority;
    }

    @Override
    public void showMenu(Scanner sc) {
        boolean it = true;
        while (it) {
            System.out.println("------------------------------------");
            System.out.println("| 1. Them benh nhan moi             |");
            System.out.println("| 2. Hen lich kham cho benh nhan    |");
            System.out.println("| 3. Xem lich hen kham              |");
            System.out.println("| 4. Xem thong tin benh nhan        |");
            System.out.println("| 0. Log out                        |");
            System.out.println("------------------------------------");
            int choice = exec.readInt("Hay nhap lua chon chuc nang: ");
            
            switch (choice) {
                case 1:
                    exec.inputPatientInfo();
                    break;
                case 2:
                    exec.henLichKham();
                    break;
                case 3:
                    exec.xemLichKham();
                    break;
                case 4:
                    exec.readPatientInfoFromFile();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }
        this.name = name.trim();
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        if (bday == null || bday.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }
        this.bday = bday.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }

        this.gender = gender.trim();
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        if (sickness == null || sickness.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }
        this.sickness = sickness.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        if (priority == null || priority.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong hop le!! Hay nhap lai.");
        }
        this.priority = priority.trim();
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void print_Out_Patients_Information() {
        System.out.println("\nTen benh nhan la: " + name);
        System.out.println("Ngay sinh benh nhan la: " + bday);
        System.out.println("Gioi tinh benh nhan la: " + gender);
        System.out.println("Trieu chung cua benh nhan la: " + sickness);
        System.out.println("Muc do uu tien la: " + priority);
    }

}
