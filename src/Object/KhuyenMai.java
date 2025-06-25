/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.util.Date;

/**
 *
 * @author Tiến Trần
 */
public class KhuyenMai {
    private int maGiam;
    private String tenGiamGia;
    private int phanTramGiam;
    private int dieuKien;
    private Date ngayBD;
    private Date ngayKT;

    public KhuyenMai() {
    }

    public KhuyenMai(int maGiam, String tenGiamGia, int phanTramGiam, int dieuKien, Date ngayBD, Date ngayKT) {
        this.maGiam = maGiam;
        this.tenGiamGia = tenGiamGia;
        this.phanTramGiam = phanTramGiam;
        this.dieuKien = dieuKien;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public int getMaGiam() {
        return maGiam;
    }

    public String getTenGiamGia() {
        return tenGiamGia;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public int getDieuKien() {
        return dieuKien;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setMaGiam(int maGiam) {
        this.maGiam = maGiam;
    }

    public void setTenGiamGia(String tenGiamGia) {
        this.tenGiamGia = tenGiamGia;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public void setDieuKien(int dieuKien) {
        this.dieuKien = dieuKien;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "maGiam=" + maGiam + ", tenGiamGia=" + tenGiamGia + ", phanTramGiam=" + phanTramGiam + ", dieuKien=" + dieuKien + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + '}';
    }
    
}
