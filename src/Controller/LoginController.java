/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ADMIN
 */

import Object.User;
import Model.UserModel;
import View.LoginForm;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {
    private LoginForm view;
    private UserModel model;

    public LoginController(LoginForm view) {
        this.view = view;
        this.model = new UserModel();
    }

    public void login() {
        String employeeId = view.getTxtUsername().getText().trim();
        String password = new String(view.getTxtPassword().getPassword()).trim();

        if (employeeId.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            User user = model.authenticateUser(employeeId, password);
            if (user != null) {
                // Login successful
                JOptionPane.showMessageDialog(view, "Đăng nhập thành công!\nXin chào " + user.getFullName(), 
                    "Thành công", JOptionPane.INFORMATION_MESSAGE);
            
            // Đóng cửa sổ đăng nhập
            view.dispose();

            // Mở giao diện chính (Home)
            javax.swing.SwingUtilities.invokeLater(() -> {
                javax.swing.JFrame mainFrame = new javax.swing.JFrame("Trang chủ");
                mainFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setLocationRelativeTo(null); // Canh giữa màn hình
                mainFrame.setContentPane(new View.MainView()); // Giao diện Home
                mainFrame.setVisible(true);
            });
            
            } else { 
                JOptionPane.showMessageDialog(view, "Sai tên đăng nhập hoặc mật khẩu!", 
                    "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Lỗi kết nối cơ sở dữ liệu: " + ex.getMessage(), 
                "Lỗi hệ thống", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
