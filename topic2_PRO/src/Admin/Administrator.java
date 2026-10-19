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

public class Administrator extends Role {

    public Administrator() {
        super("Quản trị viên");
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
            int choice = sc.nextInt();
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
