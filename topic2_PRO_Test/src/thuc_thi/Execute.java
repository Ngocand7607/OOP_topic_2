/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_thi;

import bac_si.Doctor;
import benh_nhan.Receptionists;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DUONG NGOC AN
 */
public class Execute {

    private Scanner sc;                                   // dung chung 1 Scanner cho ca chuong trinh
    private ArrayList<Receptionists> waitingList = new ArrayList<>(); // danh sach benh nhan dang cho
    private int ticketCounter = 0;                        // so ve da phat (moi lan phat +1)

    public Execute(Scanner sc) {
        this.sc = sc;
    }

    // =====================================================================
    // CAC HAM NHAP DU LIEU (nhap sai thi bao loi va bat nhap lai)
    // =====================================================================

    // Nhap 1 so nguyen. Nhap chu thi bao loi, khong bi crash
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

    // Nhap 1 so nguyen nam trong khoang min..max
    public int readIntInRange(String message, int min, int max) {
        while (true) {
            int n = readInt(message);
            if (n >= min && n <= max) {
                return n;
            }
            System.out.println("Gia tri phai tu " + min + " den " + max + "! Hay nhap lai.");
        }
    }

    // Nhap chuoi CHI GOM CHU (cho phep dau cach). Dung cho ten, gioi tinh, uu tien, chuyen khoa
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

    // Nhap chuoi gom chu, so, dau cach va , . -  (dung cho trieu chung, chan doan)
    public String readText(String message) {
        while (true) {
            System.out.print(message);
            String s = sc.nextLine().trim();
            if (isText(s)) {
                return s;
            }
            System.out.println("Khong hop le! Chi duoc nhap chu, so va cac dau , . -");
        }
    }

    // Nhap muc do uu tien: CHI nhan 1 trong 3 gia tri normal / urgent / emergency
    // (khong phan biet chu hoa chu thuong, nhap sai thi bat nhap lai)
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

    // Nhap ngay sinh trong 1 lan, dang dd/MM/yyyy (vi du: 25/12/2000)
    // Cac gioi han (nam tu 1800, ngay phai co that, khong o tuong lai) duoc kiem tra ngam,
    // khong hien ra man hinh
    public String readBirthday() {
        LocalDate today = LocalDate.now();

        while (true) {
            System.out.print("Hay nhap ngay sinh benh nhan (dd/MM/yyyy): ");
            String line = sc.nextLine().trim();

            // Cho phep go dau - hoac . thay cho dau / (vd 1-1-2000 hay 1.1.2000), doi het ve dau /
            line = line.replace('-', '/').replace('.', '/');

            // Tach chuoi theo dau "/" thanh 3 phan: ngay, thang, nam
            String[] parts = line.split("/");

            // Phai du 3 phan, ngay & thang toi da 2 chu so, nam dung 4 chu so, tat ca chi la SO
            boolean ok = parts.length == 3
                    && isDigits(parts[0]) && parts[0].length() <= 2
                    && isDigits(parts[1]) && parts[1].length() <= 2
                    && isDigits(parts[2]) && parts[2].length() == 4;

            if (ok) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                // Kiem tra ngam: nam tu 1800, thang 1-12, ngay co that trong thang
                if (year >= 1800 && month >= 1 && month <= 12
                        && day >= 1 && day <= daysInMonth(month, year)) {
                    // Khong cho ngay sinh o tuong lai
                    LocalDate birth = LocalDate.of(year, month, day);
                    if (!birth.isAfter(today)) {
                        // %02d nghia la in 2 chu so, thieu thi them so 0 (vd 5 -> 05)
                        return String.format("%02d/%02d/%d", day, month, year);
                    }
                }
            }
            System.out.println("Ngay sinh khong hop le! Chi nhap so, vi du: 25/12/2000 hoac 25-12-2000.");
        }
    }

    // true neu chuoi khong rong va chi gom chu so 0-9
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

    // ----- Cac ham kiem tra nho -----

    // true neu chuoi khong rong va chi co chu cai hoac dau cach
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

    // true neu chuoi khong rong va chi co chu, so, dau cach, dau , . -
    private boolean isText(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean ok = Character.isLetterOrDigit(c) || c == ' ' || c == ',' || c == '.' || c == '-';
            if (!ok) {
                return false;
            }
        }
        return true;
    }

    // So ngay cua 1 thang (co tinh nam nhuan cho thang 2)
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

    // =====================================================================
    // LE TAN: nhap benh nhan moi + in ve cho
    // =====================================================================

    public void inputPatientInfo() {
        Receptionists patient = new Receptionists(); // 1 benh nhan moi

        patient.setName(readLetters("Hay nhap ten benh nhan (chi chu): "));
        patient.setBday(readBirthday()); // readBirthday() tu in cau hoi nhap ngay sinh
        patient.setGender(readLetters("Hay nhap gioi tinh benh nhan (chi chu): "));
        patient.setSickness(readText("Hay nhap trieu chung benh nhan: "));
        patient.setPriority(readPriority());

        ticketCounter = ticketCounter + 1;        // so ve = so ve truoc + 1 (n + 1)
        patient.setTicketNumber(ticketCounter);
        waitingList.add(patient);                 // them vao cuoi hang cho

        patient.print_Out_Patients_Information();
        printQueueTicket(patient);
    }

    // In ve cho cua benh nhan
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

    // =====================================================================
    // BAC SI: xem danh sach cho + kham benh
    // =====================================================================

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

    // Bac si kham benh nhan dung dau hang cho
    public void examinePatient(Doctor doc) {
        if (waitingList.isEmpty()) {
            System.out.println("Hien khong co benh nhan nao cho kham.");
            return;
        }

        Receptionists patient = waitingList.get(0); // nguoi dung dau hang
        System.out.println("\nGoi so " + String.format("%03d", patient.getTicketNumber()) + " vao kham");
        patient.print_Out_Patients_Information();

        // Lan dau thi hoi ten bac si, cac lan sau dung lai
        if (doc.getDoctorName() == null) {
            doc.setDoctorName(readLetters("Vui long nhap ten bac si kham (chi chu): "));
        }
        doc.setDepartment(readLetters("Chi thi chuyen khoa (chi chu): "));
        doc.printExaminationInfo();

        doc.setFinal_diagnosis(readText("Nhap chan doan sau cung: "));

        waitingList.remove(0); // kham xong thi bo khoi hang cho
        System.out.println("\nDa hoan tat kham cho benh nhan " + patient.getName()
                + ". Chan doan: " + doc.getFinal_diagnosis());
    }

    // =====================================================================
    // QUAN TRI VIEN (dung cho bao cao sau nay)
    // =====================================================================

    public int getWaitingCount() {
        return waitingList.size();
    }

    public int getTicketCounter() {
        return ticketCounter;
    }

}