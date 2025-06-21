package View;

import java.awt.*;
import javax.swing.*;
import Object.Product;

public class InvoiceItemPanel extends JPanel {
    private final Product product;
    private int quantity = 1;

    private final JLabel quantityLabel;
    private final JLabel totalPriceLabel;

    private final Runnable updateTotalCallback;

    public InvoiceItemPanel(Product p, Runnable updateTotalCallback) {
        this.product = p;
        this.updateTotalCallback = updateTotalCallback;

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // full chiều ngang

        JLabel nameLabel = new JLabel(p.getName());
        nameLabel.setPreferredSize(new Dimension(100, 25));

        JButton decreaseBtn = new JButton("-");
        decreaseBtn.setMargin(new Insets(2, 5, 2, 5));
        JButton increaseBtn = new JButton("+");
        increaseBtn.setMargin(new Insets(2, 5, 2, 5));

        quantityLabel = new JLabel(String.valueOf(quantity));
        quantityLabel.setPreferredSize(new Dimension(30, 25));
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);

        double unitPrice = p.getPrice();
        totalPriceLabel = new JLabel(String.format("%.0f VNĐ", unitPrice * quantity));
        totalPriceLabel.setPreferredSize(new Dimension(80, 25));
        totalPriceLabel.setForeground(new Color(0, 102, 204));

        JButton optionButton = new JButton("...");
        optionButton.setMargin(new Insets(2, 5, 2, 5));

        // ➖ Giảm số lượng
        decreaseBtn.addActionListener(e -> {
            if (quantity > 1) {
                quantity--;
                updateQuantity(unitPrice);
                updateTotalCallback.run(); // 👉 gọi lại cập nhật tổng tiền
            }
        });

        increaseBtn.addActionListener(e -> {
            quantity++;
            updateQuantity(unitPrice);
            updateTotalCallback.run(); // 👉 gọi lại cập nhật tổng tiền
        });


        add(nameLabel);
        add(decreaseBtn);
        add(quantityLabel);
        add(increaseBtn);
        add(totalPriceLabel);
        add(optionButton);
    }

    private void updateQuantity(double unitPrice) {
        quantityLabel.setText(String.valueOf(quantity));
        totalPriceLabel.setText(String.format("%.0f VNĐ", unitPrice * quantity));
    }

    // ⭐ Getter cho controller dùng
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
