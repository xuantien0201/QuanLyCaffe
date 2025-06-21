package Controller;

import Model.KhachHangModel;
import Object.KhachHang;

import java.util.ArrayList;

public class KhachHangController {
    private final KhachHangModel khachHangModel = new KhachHangModel();

    public ArrayList<KhachHang> getListKhachHang() {
        return khachHangModel.getListKhachHang();
    }

    public ArrayList<KhachHang> timKiemKhachHangTheoTen(ArrayList<KhachHang> list, String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase().trim();
        ArrayList<KhachHang> result = new ArrayList<>();
        for (KhachHang kh : list) {
            if (kh.getHoTen().toLowerCase().contains(tuKhoa) ||
                kh.getGioiTinh().toLowerCase().contains(tuKhoa)) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> timKiemKhachHangTheoChiTieu(ArrayList<KhachHang> list, String minStr, String maxStr) {
        try {
            int min = Integer.parseInt(minStr.replace(",", "").trim());
            int max = Integer.parseInt(maxStr.replace(",", "").trim());
            ArrayList<KhachHang> result = new ArrayList<>();
            for (KhachHang kh : list) {
                float chiTieu = kh.getTongChiTieu();
                if (chiTieu >= min && chiTieu <= max) {
                    result.add(kh);
                }
            }
            return result;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public boolean themKhachHang(String hoTen, String gioiTinh) {
        if (hoTen.isBlank() || gioiTinh.equals("Chọn giới tính")) {
            return false;
        }
        KhachHang kh = new KhachHang(0, hoTen, gioiTinh, 0);
        return khachHangModel.addKhachHang(kh);
    }

    public boolean suaKhachHang(String maStr, String hoTen, String gioiTinh) {
        try {
            int maKH = Integer.parseInt(maStr);
            if (hoTen.isBlank()) return false;
            KhachHang kh = new KhachHang(maKH, hoTen, gioiTinh, 0);
            return khachHangModel.updateKhachHang(maKH, kh);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean xoaKhachHang(String maStr) {
        try {
            int maKH = Integer.parseInt(maStr);
            return khachHangModel.deleteKhachHang(maKH);
        } catch (Exception e) {
            return false;
        }
    }
}
