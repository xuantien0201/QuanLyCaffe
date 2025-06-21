/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Object.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

public class HoaDonModel {
    private MyConnection myConn;

    public HoaDonModel() {
        myConn = new MyConnection(); // bạn phải có lớp này để lấy kết nối
    }

    public boolean themHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO HoaDon (ngayLap, gioVao, gioRa, nguoiLap, " +
                     "danhSachSanPham, soLuongSanPham, tongTien, khuyenMai, tongTienThuc) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = myConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, new Date(hoaDon.getNgayLap().getTime()));
            stmt.setTime(2, Time.valueOf(hoaDon.getGioVao()));
            stmt.setTime(3, Time.valueOf(hoaDon.getGioRa()));
            stmt.setString(4, hoaDon.getNguoiLap());
            stmt.setString(5, hoaDon.getDanhSachSanPham());
            stmt.setString(6, hoaDon.getSoLuongSanPham());
            stmt.setDouble(7, hoaDon.getTongTien());
            stmt.setDouble(8, hoaDon.getKhuyenMai());
            stmt.setDouble(9, hoaDon.getTongTienThuc());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
