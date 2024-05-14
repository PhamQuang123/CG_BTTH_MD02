package model;

import java.util.Date;

public class BenhAnThuong extends BenhAn{
    private double vienPhi;

    public BenhAnThuong() {
    }

    public BenhAnThuong(double vienPhi) {
        this.vienPhi = vienPhi;
    }

    public BenhAnThuong(int stt, String maBenhAn, String maBenhNhan, String tenBanhNhan, Date ngayNhapVien, Date ngayRaVien, String lyDo, double vienPhi) {
        super(stt, maBenhAn, maBenhNhan, tenBanhNhan, ngayNhapVien, ngayRaVien, lyDo);
        this.vienPhi = vienPhi;
    }

    public double getVienPhi() {
        return vienPhi;
    }

    public void setVienPhi(double vienPhi) {
        this.vienPhi = vienPhi;
    }
}
