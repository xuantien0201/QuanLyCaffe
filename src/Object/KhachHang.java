/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Tiến Trần
 */
public class KhachHang {
    private int MaKH;
    private String hoTen;
    private String gioiTinh;
    private float tongChiTieu;

    public KhachHang() {
    }

    public KhachHang(int MaKH, String hoTen, String gioiTinh, float tongChiTieu) {
        this.MaKH = MaKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tongChiTieu = tongChiTieu;
    }

    public int getMaKH() {
        return MaKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public float getTongChiTieu() {
        return tongChiTieu;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setTongChiTieu(float tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }
    
    
}
