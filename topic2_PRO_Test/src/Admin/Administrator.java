/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

/**
 *
 * @author DUONG NGOC AN
 */
import Role.Role;
import java.util.Scanner;
import thuc_thi.Execute;

public class Administrator extends Role {

    private Execute exec;

    public Administrator(Execute exec) {
        super("Quản trị viên");
        this.exec = exec;
    }

    @Override
    public void showMenu(Scanner sc) {
        boolean it = true;
        while (it) {

            System.out.println("\n==================================");
            System.out.println("1. Danh sach cac khoa");
            System.out.println("2. So luot cua tung khoa");
            System.out.println("0. Log out");
            System.out.println("==================================");
            int choice = exec.readInt("Hay nhap lua chon chuc nang: ");
            switch (choice) {
                case 1:
                    System.out.println("DANH SACH CAC KHOA KHAM ");
                    break;

                case 2:
                    System.out.println("BAO CAO SO LUOT THAM KHAM CUA TUNG KHOA ");
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

}