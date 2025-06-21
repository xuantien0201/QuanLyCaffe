package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {
    JPanel pnMenu, pnCard;
    JLabel lblKhachHang, lblHoaDon;
    CardLayout cardLayout;
    KhachHangView khachHangView;
    Home homeView;

    public MainView() {
        setTitle("Phần mềm quản lý Cafe");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        setVisible(true);
    }

    private void initGUI() {
        Container con = getContentPane();
        con.setLayout(new BorderLayout());

        // ========== MENU BÊN TRÁI ==========
        pnMenu = new JPanel();
        pnMenu.setPreferredSize(new Dimension(200, 0));
        pnMenu.setBackground(new Color(63, 74, 89));
        pnMenu.setLayout(new BoxLayout(pnMenu, BoxLayout.Y_AXIS));

        lblKhachHang = new JLabel("  Quản lý khách hàng");
        styleMenuLabel(lblKhachHang);

        lblHoaDon = new JLabel("  Quản lý hóa đơn");
        styleMenuLabel(lblHoaDon);

        pnMenu.add(Box.createVerticalStrut(20));
        pnMenu.add(lblKhachHang);
        pnMenu.add(lblHoaDon);

        // ========== KHU VỰC HIỂN THỊ CHÍNH ==========
        cardLayout = new CardLayout();
        pnCard = new JPanel(cardLayout);

        khachHangView = new KhachHangView();
        pnCard.add(khachHangView, "KhachHang");

        homeView = new Home();
        pnCard.add(homeView, "HoaDon");

        // ========== SỰ KIỆN ==========
        lblKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(pnCard, "KhachHang");
                highlightMenu(lblKhachHang);
            }
        });

        lblHoaDon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(pnCard, "HoaDon");
                highlightMenu(lblHoaDon);
            }
        });

        // ========== GẮN VÀO FRAME ==========
        con.add(pnMenu, BorderLayout.WEST);
        con.add(pnCard, BorderLayout.CENTER);

        // Mặc định hiển thị khách hàng
        cardLayout.show(pnCard, "KhachHang");
        highlightMenu(lblKhachHang);
    }

    private void styleMenuLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setOpaque(true);
        label.setBackground(new Color(63, 74, 89));
        label.setPreferredSize(new Dimension(200, 50));
        label.setMaximumSize(new Dimension(200, 50));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void highlightMenu(JLabel selected) {
        lblKhachHang.setBackground(new Color(63, 74, 89));
        lblHoaDon.setBackground(new Color(63, 74, 89));
        selected.setBackground(new Color(51, 202, 187));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView());
    }
}
