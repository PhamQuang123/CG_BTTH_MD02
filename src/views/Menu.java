package views;

import imp.BenhAnThuongImp;
import imp.BenhAnVIPImp;
import model.BenhAn;
import model.BenhAnThuong;
import model.BenhAnVip;
import service.Service;
import util.ConnectionDB;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public static List<BenhAn> listBenhAn;
    public static List<BenhAnThuong> listAnThuong;
    public static List<BenhAnVip> listBenhAnVip;
    private static BenhAnThuongImp benhAnThuong = new BenhAnThuongImp();
    private static BenhAnVIPImp benhAnVIPImp = new BenhAnVIPImp();

    public Menu() {
        listBenhAn = ConnectionDB.readDataFromFile("src/data/benhAn.txt", listBenhAn);
    }

    public void menu() {
        do {
            System.out.println("***** Quản Lý Bệnh Án *****");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xoá");
            System.out.println("3. Xem danh sách các bệnh án");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        doAdd();
                        break;
                    case 2:
                        delete();
                        break;
                    case 3:
//                        display();
                        break;
                    case 4:
                        ConnectionDB.writeDataToFile("src/data/benhAn.txt", listBenhAn);
                        System.exit(0);
                        break;
                }
                if (choice < 1 || choice > 4) {
                    System.out.println("Vui lòng chọn 1-4, nhập lại");
                }
            } catch (Exception ex) {
                System.out.println("Dữ liệu nhập vào phải là ký tự số nguyên dương, nhập lại");
            }
        } while (true);
    }

    public static void doAdd() {
        System.out.println("Chọn loại bênh án muốn thêm: ");
        System.out.println("1, Bệnh án thường \t 2. Bệnh a VIP");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            benhAnThuong.doAdd();
        } else {
            benhAnVIPImp.doAdd();
        }
    }

    public static void delete() {
        benhAnThuong.delete();
    }
}
