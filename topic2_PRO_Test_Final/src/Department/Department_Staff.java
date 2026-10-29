/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Department;

import java.util.Scanner;
import thuc_thi.Execute;

/**
 *
 * @author DUONG NGOC AN
 */
public class Department_Staff extends Role.Role {

    private Execute exec;

    public Department_Staff(Execute exec) {
        super("Nhan vien khoa");
        this.exec = exec;
    }

    @Override
    public void showMenu(Scanner sc) {
        boolean it = true;
        while (it) {
            System.out.println("\n==================================");
            System.out.println("1. Xem danh sach benh nhan dang cho");
            System.out.println("2. Goi benh nhan vao phong");
            System.out.println("0. Log out");
            System.out.println("==================================");
            int choice = exec.readInt("Hay nhap lua chon chuc nang: ");
            switch (choice) {
                case 1:
                    exec.showWaitingList(); 
                    break;
                case 2:
                    exec.callPatient();
                    break;
                case 0:
                    System.out.println("CAM ON BAN DA SU DUNG DICH VU");
                    it = false;
                    break;
                default:
                    System.out.println("HAY CHON LAI!!!");
            }
        }

    }

}
