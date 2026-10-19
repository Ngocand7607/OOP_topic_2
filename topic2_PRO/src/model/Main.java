/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Role.Role;
import bac_si.Doctor;
import Admin.Administrator;
import benh_nhan.Receptionists;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Role userRole = null;

        boolean it = true;

        while (it) {

            System.out.println("------------------------------------");
            System.out.println("| 1. Bac si (Doctor)                |");
            System.out.println("| 2. Quan tri vien (Administrator)  |");
            System.out.println("| 3. Le tan (Receptionist)          |");
            System.out.println("| 4. Log out                        |");
            System.out.println("------------------------------------");
            System.out.print("Hay dua ra lua chon truy cap: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ban da truy cap voi vai tro la Bac si");
                    userRole = new Doctor();
                    break;
                case 2:
                    System.out.println("Ban da truy cap voi vai tro la Quan tri vien");
                    userRole = new Administrator();
                    break;
                case 3:
                    System.out.println("Ban da truy cap voi vai tro la Le tan");
                    userRole = new Receptionists();
                    break;
                case 4:
                    System.out.println("Cam on ban da tin tuong su dung dich vu cua chung toi!!");
                    it = false;
                    userRole = null;
                    break;
                default:
                    System.out.println("invalid input!");
                    userRole = null;
                    break;
            }

            if (userRole != null) {
                userRole.showMenu(sc);
                break;
            }
        }

    }

}
