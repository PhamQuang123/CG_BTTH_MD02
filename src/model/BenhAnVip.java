package model;

import java.util.Date;

public class BenhAnVip extends BenhAn{
    private String loaiVip;
    private Date thoiHAn;

    public BenhAnVip(int stt, String maBenhAn, String maBenhNhan, String tenBanhNhan, Date ngayNhapVien, Date ngayRaVien, String lyDo, String loaiVip, Date thoiHAn) {
        super(stt, maBenhAn, maBenhNhan, tenBanhNhan, ngayNhapVien, ngayRaVien, lyDo);
        this.loaiVip = loaiVip;
        this.thoiHAn = thoiHAn;
    }

    public BenhAnVip() {
    }




    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }
}
