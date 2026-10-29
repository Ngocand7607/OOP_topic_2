/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_thi;

import bac_si.Doctor;
import benh_nhan.Receptionists;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUONG NGOC AN
 */
public class Execute {

    private Scanner sc;
    private ArrayList<Receptionists> waitingList = new ArrayList<>();
    private int ticketCounter = 0;
    private ArrayList<String> danhSachLichHen = new ArrayList<>();
    Map<String, Integer> soLuotKhamCacPhongKhoa = new LinkedHashMap<>();
    private Receptionists currentPatient = null;

    public Execute(Scanner sc) {
        this.sc = sc;

        soLuotKhamCacPhongKhoa.put("Khoa Cap Cuu", 0);
        soLuotKhamCacPhongKhoa.put("Khoa San Phu", 0);
        soLuotKhamCacPhongKhoa.put("Khoa Sanh", 0);
        soLuotKhamCacPhongKhoa.put("Khoa So Sinh", 0);
        soLuotKhamCacPhongKhoa.put("Khoa Nhi", 0);
        soLuotKhamCacPhongKhoa.put("Khoa Kham Phu Khoa", 0);
    }

    public String selectDepartment() {
        ArrayList<String> cacPhongKhoa = new ArrayList<>(soLuotKhamCacPhongKhoa.keySet());
        System.out.println("| -------------------------------- | ");
        for (int i = 0; i < cacPhongKhoa.size(); i++) {
            System.out.println((i + 1) + "." + cacPhongKhoa.get(i));
        }
        System.out.println("| -------------------------------- | ");
        int choice = readIntInRange("Hay chon khoa chi thi (1 - " + cacPhongKhoa.size() + "): ",
                1, cacPhongKhoa.size());
        return cacPhongKhoa.get(choice - 1);

    }

    public void updateDepartment(String khoa) {
        int soLuot = soLuotKhamCacPhongKhoa.get(khoa);
        soLuot++;
        soLuotKhamCacPhongKhoa.put(khoa, soLuot);
    }

    public int readInt(String message) {
        while (true) {
            System.out.print(message);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Chi duoc nhap so! Hay nhap lai.");
            }
        }
    }

    public int readIntInRange(String message, int min, int max) {
        while (true) {
            int n = readInt(message);
            if (n >= min && n <= max) {
                return n;
            }
            System.out.println("Gia tri phai tu " + min + " den " + max + "! Hay nhap lai.");
        }
    }

    public String readLetters(String message) {
        while (true) {
            System.out.print(message);
            String s = sc.nextLine().trim();
            if (isLetters(s)) {
                return s;
            }
            System.out.println("Khong hop le! Chi duoc nhap chu, khong nhap so hay ky tu dac biet.");
        }
    }

    public String readGender(String message) {
        while (true) {
            System.out.print(message);
            String s = sc.nextLine().trim();
            if (isLetters(s)) {
                if (s.equalsIgnoreCase("nam")) {
                    return "Nam";
                }
                if (s.equalsIgnoreCase("nu")) {
                    return "Nu";
                }
            }
            System.out.println("Khong hop le! Gioi tinh chi duoc nhap nam hoac nu khong nhap so hay ky tu dac biet.");
        }
    }

    public String readText(String message) {
        while (true) {
            System.out.print(message);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Khong duoc de trong!!! Hay nhap lai trieu chung");
                continue;
            }
            if (isText(s)) {
                return s;
            }
            System.out.println("Khong hop le! Chi duoc nhap chu, so va cac dau , . - : / () ");
        }
    }

    public String readPriority() {
        while (true) {
            System.out.print("Muc do uu tien (normal / urgent / emergency): ");
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("normal")) {
                return "Normal";
            }
            if (s.equalsIgnoreCase("urgent")) {
                return "Urgent";
            }
            if (s.equalsIgnoreCase("emergency")) {
                return "Emergency";
            }
            System.out.println("Khong hop le! Chi duoc nhap normal, urgent hoac emergency.");
        }
    }

    public String readBirthday() {
        LocalDate today = LocalDate.now();

        while (true) {
            System.out.print("Hay nhap ngay sinh benh nhan (dd/MM/yyyy): ");
            String line = sc.nextLine().trim();

            line = line.replace('-', '/').replace('.', '/');

            String[] parts = line.split("/");

            boolean ok = parts.length == 3
                    && isDigits(parts[0]) && parts[0].length() <= 2
                    && isDigits(parts[1]) && parts[1].length() <= 2
                    && isDigits(parts[2]) && parts[2].length() == 4;

            if (ok) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (year >= 1800 && month >= 1 && month <= 12
                        && day >= 1 && day <= daysInMonth(month, year)) {
                    LocalDate birth = LocalDate.of(year, month, day);
                    if (!birth.isAfter(today)) {
                        return String.format("%02d/%02d/%d", day, month, year);
                    }
                }
            }
            System.out.println("Ngay sinh khong hop le! Chi nhap so, vi du: 25/12/2000 hoac 25-12-2000.");
        }
    }

    private boolean isDigits(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isLetters(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    private boolean isText(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean ok = Character.isLetterOrDigit(c) || c == ' ' || c == ',' || c == '.' || c == '-'
                    || c == '(' || c == ')' || c == ':' || c == '/';
            if (!ok) {
                return false;
            }
        }
        return true;
    }

    private int daysInMonth(int month, int year) {
        if (month == 2) {
            boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (leap) {
                return 29;
            }
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }

    public void inputPatientInfo() {
        Receptionists patient = new Receptionists();

        patient.setName(readLetters("Hay nhap ten benh nhan: "));
        patient.setBday(readBirthday());
        patient.setGender(readGender("Hay nhap gioi tinh benh nhan: "));
        patient.setSickness(readText("Hay nhap trieu chung cua benh nhan: "));
        patient.setPriority(readPriority());

        ticketCounter = ticketCounter + 1;
        patient.setTicketNumber(ticketCounter);
        waitingList.add(patient);

        patient.print_Out_Patients_Information();
        printQueueTicket(patient);
    }

    public void printQueueTicket(Receptionists patient) {
        System.out.println("\n==================================");
        System.out.println("          VE CHO KHAM BENH        ");
        System.out.println("==================================");
        System.out.println("  So thu tu : " + String.format("%03d", patient.getTicketNumber()));
        System.out.println("  Benh nhan : " + patient.getName());
        System.out.println("  Uu tien   : " + patient.getPriority());
        System.out.println("  Truoc ban : " + (waitingList.size() - 1) + " benh nhan");
        System.out.println("----------------------------------");
        System.out.println("  Vui long cho den khi duoc goi so  ");
        System.out.println("==================================");

    }

    public void showWaitingList() {
        System.out.println("DANH SACH BENH NHAN CHO KHAM");
        if (waitingList.isEmpty()) {
            System.out.println("(Hien khong co benh nhan nao dang cho)");
            return;
        }

        for (int i = 0; i < waitingList.size(); i++) {
            Receptionists p = waitingList.get(i);
            System.out.println("  #" + String.format("%03d", p.getTicketNumber())
                    + " | " + p.getName()
                    + " | Uu tien: " + p.getPriority()
                    + " | Trieu chung: " + p.getSickness());
        }

    }

    public void henLichKham() {
        System.out.println("\n--- TIEP NHAN HEN LICH KHAM ---");
        String tenBN = readLetters("Hay nhap ten benh nhan: ");
        String khoa = selectDepartment();
        String ngayKham = readAppointmentDate();
        String thongTin = "Benh nhan: " + tenBN + " | Khoa: " + khoa + " | Ngay hen: " + ngayKham;
        danhSachLichHen.add(thongTin);
        System.out.println("--- HEN LICH KHAM THANH CONG! ---");
    }

    public String readAppointmentDate() {
        LocalDate today = LocalDate.now();

        while (true) {
            System.out.print("Hay nhap ngay hen kham cua benh nhan (dd/MM/yyyy): ");
            String line = sc.nextLine().trim();

            line = line.replace('-', '/').replace('.', '/');

            String[] parts = line.split("/");

            boolean ok = parts.length == 3
                    && isDigits(parts[0]) && parts[0].length() <= 2
                    && isDigits(parts[1]) && parts[1].length() <= 2
                    && isDigits(parts[2]) && parts[2].length() == 4;

            if (ok) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (year >= 2026 && month >= 1 && month <= 12
                        && day >= 1 && day <= daysInMonth(month, year)) {
                    LocalDate date = LocalDate.of(year, month, day);
                    if (!date.isBefore(today)) {
                        return String.format("%02d/%02d/%d", day, month, year);
                    }
                }
            }
            System.out.println("Ngay hen kham khong hop le! Chi nhap so, vi du: 25/12/2000 hoac 25-12-2000.");
        }
    }

    public void hienDanhSachKhoaKham() {
        ArrayList<String> cacPhongKhoa = new ArrayList<>(soLuotKhamCacPhongKhoa.keySet());
        System.out.println("| -------------------------------- | ");
        for (int i = 0; i < cacPhongKhoa.size(); i++) {
            System.out.println((i + 1) + "." + cacPhongKhoa.get(i));
        }
        System.out.println("| -------------------------------- | ");
    }

    public void hienSoLuotKhamCacKhoa() {
        ArrayList<String> cacPhongKhoa = new ArrayList<>(soLuotKhamCacPhongKhoa.keySet());
        System.out.println("| -------------------------------- | ");
        for (int i = 0; i < cacPhongKhoa.size(); i++) {
            String khoa = cacPhongKhoa.get(i);
            int soLuot = soLuotKhamCacPhongKhoa.get(khoa);
            System.out.println((i + 1) + "." + khoa + ':'
                    + soLuot + " luot kham");
        }
        System.out.println("| -------------------------------- | ");
    }

    public void xemLichKham() {
        System.out.println("\n--- DANH SACH LICH HEN KHAM ---");
        if (danhSachLichHen.isEmpty()) {
            System.out.println("(Hien chua co lich hen nao)");
            return;
        }
        for (int i = 0; i < danhSachLichHen.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + danhSachLichHen.get(i));
        }

    }

    public void examinePatient(Doctor doc) {
        if (currentPatient == null) {
            System.out.println("Trong phong chua co benh nhan! "
                    + "Vui long cho Nhan vien khoa goi so truoc.");
            return;
        }

        if (doc.getDoctorName() == null) {
            doc.setDoctorName(readLetters("Vui long nhap ten bac si kham (chi chu): "));
        }

        doc.setFinal_diagnosis(readText("Nhap chan doan sau cung: "));

        doc.printDoctorInfo();

        String chonKhoa = selectDepartment();
        updateDepartment(chonKhoa);
        doc.setDepartment(chonKhoa);

        System.out.println("\nDa hoan tat kham cho benh nhan " + currentPatient.getName()
                + ". Chan doan: " + doc.getFinal_diagnosis());

        savePatientInfoToFile(currentPatient, doc);
        currentPatient = null;
    }

    public void callPatient() {
        if (currentPatient != null) {
            System.out.println("Phong kham dang co benh nhan ...");
            return;
        }

        if (waitingList.isEmpty()) {
            System.out.println("Hien khong co benh nhan nao dang cho!");
            return;
        }

        int priPo = -1;
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getPriority().equalsIgnoreCase("emergency")) {
                priPo = i;
                break;
            }
        }

        if (priPo == -1) {
            for (int j = 0; j < waitingList.size(); j++) {
                if (waitingList.get(j).getPriority().equalsIgnoreCase("urgent")) {
                    priPo = j;
                    break;
                }
            }
        }

        if (priPo == -1) {
            priPo = 0;
        }

        currentPatient = waitingList.remove(priPo);
        System.out.println("\nMoi benh nhan so #"
                + String.format("%03d", currentPatient.getTicketNumber())
                + " (" + currentPatient.getName() + ") buoc vao phong kham!");

        currentPatient.print_Out_Patients_Information();

    }

    public void readPatientInfoFromFile() {
        try ( BufferedReader br = new BufferedReader(
                new FileReader("./du_lieu.txt"))) {
            String line;
            boolean hasData = false;

            System.out.println("\n===== DANH SACH BENH NHAN =====");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                hasData = true;
            }

            if (!hasData) {
                System.out.println("Danh sach benh nhan dang trong.");
            }

            System.out.println("===============================");

        } catch (IOException e) {
            System.out.println("Chua co file du lieu hoac loi doc file: "
                    + e.getMessage());
        }

    }

    public void savePatientInfoToFile(Receptionists patient, Doctor doc) {
        try ( BufferedWriter bw = new BufferedWriter(
                new FileWriter("./du_lieu.txt", true))) {

            bw.write("Thong tin benh nhan:");
            bw.newLine();

            bw.write("--------------------------------");
            bw.newLine();

            bw.write("Ten: " + patient.getName());
            bw.newLine();

            bw.write("Ngay sinh: " + patient.getBday());
            bw.newLine();

            bw.write("Gioi tinh: " + patient.getGender());
            bw.newLine();

            bw.write("Trieu chung: " + patient.getSickness());
            bw.newLine();

            bw.write("Muc do uu tien: " + patient.getPriority());
            bw.newLine();

            bw.write("Chan doan sau cung: " + doc.getFinal_diagnosis());
            bw.newLine();

            bw.write("--------------------------------");
            bw.newLine();

            System.out.println("Da luu thong tin benh nhan vao file!");

        } catch (IOException ex) {
            Logger.getLogger(Execute.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public int getWaitingCount() {
        return waitingList.size();
    }

    public int getTicketCounter() {
        return ticketCounter;
    }

}
