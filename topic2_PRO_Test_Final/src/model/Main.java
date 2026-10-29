 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Role.Role;
import bac_si.Doctor;
import Admin.Administrator;
import Department.Department_Staff;
import benh_nhan.Receptionists;
import java.util.Scanner;
import thuc_thi.Execute;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Execute exec = new Execute(sc);

        boolean it = true;

        while (it) {

            Role userRole = null;

            System.out.println("---------------------------------------");
            System.out.println("| 1. Bac si (Doctor)                   |");
            System.out.println("| 2. Quan tri vien (Administrator)     |");
            System.out.println("| 3. Le tan (Receptionist)             |");
            System.out.println("| 4. Nhan vien khoa (Departrment_Staff)|");
            System.out.println("| 5. Log out                           |");
            System.out.println("---------------------------------------");
            int choice = exec.readInt("Hay dua ra lua chon truy cap: ");

            switch (choice) {
                case 1:
                    System.out.println("Ban da truy cap voi vai tro la Bac si");
                    userRole = new Doctor(exec);
                    break;
                case 2:
                    System.out.println("Ban da truy cap voi vai tro la Quan tri vien");
                    userRole = new Administrator(exec);
                    break;
                case 3:
                    System.out.println("Ban da truy cap voi vai tro la Le tan");
                    userRole = new Receptionists(exec);
                    break;
                case 4:
                    System.out.println("Ban da truy cap voi vai tro la Nhan vien khoa");
                    userRole = new Department_Staff(exec);
                    break;
                case 5:
                    System.out.println("Cam on ban da tin tuong su dung dich vu cua chung toi!!");
                    it = false;
                    break;
                default:
                    System.out.println("invalid input!");
                    break;
            }

            if (userRole != null) {
                userRole.showMenu(sc);
            }
            
        }
    }
}