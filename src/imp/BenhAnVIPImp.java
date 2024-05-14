package imp;

import com.sun.jdi.request.DuplicateRequestException;
import model.BenhAn;
import model.BenhAnThuong;
import model.BenhAnVip;
import service.Service;
import views.Menu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class BenhAnVIPImp implements Service<BenhAn,String> {

    @Override
    public BenhAn doAdd() {
      int stt = inputStt();
      String  maBN = inputMaBenhNhan();
      String maBA = inputMaBenhAn();
      String ten = inpuName();
      Date ngayN = inputNgayNhapVien();
      Date ngayX = inputNgayRaVien();
      String loai = inputLoai();
      Date thoiHAn = inputThoiHan();
      String lyDo = inputLyDo();
        BenhAn a = new BenhAnVip(stt,maBA,maBN,ten,ngayN,ngayX, lyDo,loai,thoiHAn);



        return a;
    }

    public String inputLoai(){
        System.out.println("Chọn gói VIP:");
        System.out.println("1. VIP I - 2. VIP II - 3.VIP III");
        int choice = Integer.parseInt(Menu.scanner.nextLine());
        if (choice == 1){
            return "VIP I";
        } else if (choice == 2) {
            return "VIP II";

        }else {
            return "VIP III";
        }
    }
    public Date inputThoiHan(){
        System.out.println("Nhập thời hạn:");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            String inpDate = Menu.scanner.nextLine();
            try {
                Date create = sdf.parse(inpDate);
                return create;
            } catch (ParseException e) {
                System.out.println("Không đúng định dạng dd/MM/yyyy, nhập lại");
                throw new RuntimeException(e);
            }
        } while (true);
    }

    @Override
    public void delete() {
        System.out.println("Nhập mã bêệnh án cần xoá:");
        String inpuDeleteId = Menu.scanner.nextLine();
        boolean check = false;
        System.out.println("Bạn có muốn xoá không: ");
        System.out.println("1. Có \t 2. Không");
        int choice = Integer.parseInt(Menu.scanner.nextLine());
        if (choice == 1) {
            for (BenhAn b : Menu.listBenhAn
            ) {

                if (b.getMaBenhAn().equals(inpuDeleteId)) {
                    Menu.listBenhAn.remove(b);
                    check = true;
                    return;
                }
            }
            if (check == false) {
                System.out.println("Mã không tồn tại");
            }
        }
    }

    @Override
    public void display() {

    }

    public static String ngay(Date ngayNhap) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(ngayNhap);
        return today;
    }

    public BenhAn findById(String id) {
        for (BenhAn b : Menu.listBenhAn
        ) {
            if (b.getMaBenhAn().equals(id)) {
             return b;
            }
        }
        return null;
    }

    public int inputStt() {
        int maxId = 0;
        if (Menu.listBenhAn.size() == 0) {
            maxId = 0;
        } else {
            for (BenhAn benhAn : Menu.listBenhAn) {
                if (benhAn.getStt() > maxId) {
                    maxId = benhAn.getStt();
                }
            }
        }
        maxId++;
        return maxId;
    }

    public String inputMaBenhAn() {
        System.out.println("Nhập mã bệnh án:");
        do {
            String inpMaBenhAn = Menu.scanner.nextLine();
            BenhAn benhAn = findById(inpMaBenhAn);
            String regex = "BA-[0-9]{3}";
            if (Pattern.matches(regex, inpMaBenhAn)) {
                if (benhAn == null) {
                    throw new DuplicateRequestException("Bệnh án đã tồn tại, nhạp lại");
                } else {
                    return inpMaBenhAn;
                }
            } else {
                System.out.println("Mã không đúng định dạng BA-XXX, XXX là các kí tự số");
            }
        } while (true);
    }


    public String inputMaBenhNhan() {
        System.out.println("NHập mã bệnh nhân:");
        do {
            String inpMaBenhNhan = Menu.scanner.nextLine();
            BenhAn benhAn = findById(inputMaBenhNhan());
            String regex = "BN-[0-9]{3}";
            if (Pattern.matches(regex, inputMaBenhNhan())) {
                if (benhAn == null) {
                    throw new DuplicateRequestException("Bệnh án đã tồn tại, nhạp lại");
                } else {
                    return inpMaBenhNhan;
                }
            } else {
                System.out.println("Mã không đúng định dạng BA-XXX, XXX là các kí tự số");
            }
        } while (true);
    }

    public String inpuName() {
        System.out.println("Nhâ tên bệnh nhân:");
        return Menu.scanner.nextLine();
    }

    public Date inputNgayNhapVien() {
        System.out.println("Nhập ngày nhập viện:");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            String inpDate = Menu.scanner.nextLine();
            try {
                Date create = sdf.parse(inpDate);
                return create;
            } catch (ParseException e) {
                System.out.println("Không đúng định dạng dd/MM/yyyy, nhập lại");
                throw new RuntimeException(e);
            }
        } while (true);

    }

    public Date inputNgayRaVien() {
        System.out.println("Nhập ngày ra viện:");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            String inpDate = Menu.scanner.nextLine();
            try {
                Date create = sdf.parse(inpDate);
                return create;
            } catch (ParseException e) {
                System.out.println("Không đúng định dạng dd/MM/yyyy, nhập lại");
                throw new RuntimeException(e);
            }
        } while (true);
    }

    public String inputLyDo() {
        System.out.println("Nhập lý do nhập viện:");
        return Menu.scanner.nextLine();
    }
}
