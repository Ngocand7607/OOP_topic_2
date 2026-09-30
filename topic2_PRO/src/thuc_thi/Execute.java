/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_thi;

import benh_nhan.Receptionists;
import java.util.Scanner;

/**
 *
 * @author DUONG NGOC AN
 */
public class Execute {

    public static void main(String[] args) {

        Scanner ndl = new Scanner(System.in);
        
        System.out.print("Dien ten benh nhan: ");
        String ten_benh_nhan = ndl.nextLine();

        System.out.print("Ngay thang nam sinh cua benh nhan: ");
        String ngay_thang_nam_sinh = ndl.nextLine();

        System.out.print("Gioi tinh benh nhan: ");
        String gioi_tinh = ndl.nextLine();

        System.out.print("Chan doan cua benh nhan: ");
        String chan_doan_benh = ndl.nextLine();

        System.out.print("Muc do uu tien cua benh nhan: ");
        String muc_do_uu_tien = ndl.nextLine();
        Receptionists t = new Receptionists(ten_benh_nhan, ngay_thang_nam_sinh, gioi_tinh, chan_doan_benh, muc_do_uu_tien);

        t.in_thong_tin();
    }

}
