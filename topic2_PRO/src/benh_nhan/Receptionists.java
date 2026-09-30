/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package benh_nhan;

/**
 *
 * @author DUONG NGOC AN
 */
public class Receptionists {

    /**
     * @param args the command line arguments
     */
    private String name ;
    private String bday;
    private String gender;
    private String benh;
    private String priority;

    public Receptionists(String name, String bday, String gender, String benh, String priority) {
        this.name = name;
        this.bday = bday;
        this.gender = gender;
        this.benh = benh;
        this.priority = priority;
    }
    
    public void in_thong_tin(){
        System.out.println("\nTen benh nhan la: " + getName() );
        System.out.println("Ngay sinh benh nhan la: " + bday);
        System.out.println("Gioi tinh benh nhan la: " + gender);
        System.out.println("Chan doan benh nhan la: " + getBenh() );
        System.out.println("Muc do uu tien cua benh nhan la: " + priority);
        
    }
    
    public String getName(){
        return name;
    }

    public String getBenh() {
        return benh;
    }
    
    
}
