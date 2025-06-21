/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.util.Date;
public class HoaDon {
    private int maHoaDon;
    private Date ngayLap;
    private String gioVao;
    private String gioRa;
    private String nguoiLap;
    private String danhSachSanPham;    // VD: "SP01,SP02,SP03"
    private String soLuongSanPham;     // VD: "2,1,5"
    private double tongTien;
    private double khuyenMai;
    private double tongTienThuc;

    // Constructor đầy đủ
    public HoaDon(int maHoaDon, Date ngayLap, String gioVao, String gioRa, String nguoiLap,
                  String danhSachSanPham, String soLuongSanPham,
                  double tongTien, double khuyenMai, double tongTienThuc) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.nguoiLap = nguoiLap;
        this.danhSachSanPham = danhSachSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.tongTien = tongTien;
        this.khuyenMai = khuyenMai;
        this.tongTienThuc = tongTienThuc;
    }

    // Getters và Setters
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public String getNguoiLap() {
        return nguoiLap;
    }

    public void setNguoiLap(String nguoiLap) {
        this.nguoiLap = nguoiLap;
    }

    public String getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(String danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public String getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(String soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(double khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public double getTongTienThuc() {
        return tongTienThuc;
    }

    public void setTongTienThuc(double tongTienThuc) {
        this.tongTienThuc = tongTienThuc;
    }
}
