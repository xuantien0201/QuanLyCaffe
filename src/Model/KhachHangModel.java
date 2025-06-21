package Model;

import Object.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhachHangModel {

    private MyConnection myConn = new MyConnection();

    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Connection conn = myConn.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM khachhang WHERE TinhTrang=1");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new KhachHang(
                        rs.getInt("MaKH"),
                        rs.getString("HoTen"),
                        rs.getString("GioiTinh"),
                        rs.getInt("TongChiTieu")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addKhachHang(KhachHang kh) {
        try (Connection conn = myConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO khachhang(HoTen, GioiTinh, TongChiTieu, TinhTrang) VALUES (?, ?, ?, 1)")
        ) {
            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getGioiTinh());
            ps.setFloat(3, kh.getTongChiTieu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateKhachHang(int maKH, KhachHang kh) {
        try (Connection conn = myConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE khachhang SET HoTen=?, GioiTinh=? WHERE MaKH=?")
        ) {
            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getGioiTinh());
            ps.setInt(3, maKH);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteKhachHang(int maKH) {
        try (Connection conn = myConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE khachhang SET TinhTrang=0 WHERE MaKH=?")
        ) {
            ps.setInt(1, maKH);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
