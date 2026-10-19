/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_thi;
import bac_si.Doctor;
import benh_nhan.Receptionists;
import java.util.Scanner;

/**
 *
 * @author DUONG NGOC AN
 */
public class Execute {
    
    private Scanner ndl = new Scanner(System.in);
    private Receptionists patient = new Receptionists();
    public void inputPatientInfo(){
       
        System.out.print("Hay nhap ten benh nhan: ");
        patient.setName(ndl.nextLine());
        
        System.out.print("Hay nhap ngay sinh benh nhan: ");
        patient.setBday(ndl.nextLine());
        

        System.out.print("Hay nhap gioi tinh benh nhan: ");
        patient.setGender(ndl.nextLine());

        System.out.print("Hay nhap trieu chung benh nhan: ");
        patient.setSickness(ndl.nextLine());

        System.out.print("Muc do uu tien cua benh nhan: ");
        patient.setPriority(ndl.nextLine());

        patient.print_Out_Patients_Information ();

    }

    public void examinationInfo(){
        
    Doctor doc = new Doctor(patient.getName(), patient.getBday(), patient.getGender(), patient.getSickness(), patient.getPriority(), null, null);
    System.out.println ("\nIn thong tin benh nhan de bac si hoi va dien trieu chung\n");
    
    System.out.print("vui long nhap ten bac si kham: ");
    doc.setDoctorName(ndl.nextLine());
    System.out.print("Chi thi chuyen khoa (neu co ):  ");
    doc.setDepartment(ndl.nextLine()); 
    System.out.println("Thong tin benh nhan");
    doc.print_Out_Patients_Information ();
    }
    

}

