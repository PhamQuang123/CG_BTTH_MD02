package model;

import java.util.Date;

public abstract class BenhAn {
    private int stt;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBanhNhan;
    private Date ngayNhapVien;
    private Date ngayRaVien;
    private String lyDo;

    public BenhAn() {
    }

    public BenhAn(int stt, String maBenhAn, String maBenhNhan, String tenBanhNhan, Date ngayNhapVien, Date ngayRaVien, String lyDo) {
        this.stt = stt;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBanhNhan = tenBanhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBanhNhan() {
        return tenBanhNhan;
    }

    public void setTenBanhNhan(String tenBanhNhan) {
        this.tenBanhNhan = tenBanhNhan;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public Date getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(Date ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
}
