package model;

import Object.Category;
import Object.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private Model.MyConnection myConn;

    public ProductModel() {
        myConn = new Model.MyConnection();
    }

    public List<Product> getAllProducts() {
    List<Product> list = new ArrayList<>();
    String sql = """
        SELECT p.product_id, p.name, p.category_id, p.price, p.description, p.image,
               c.name AS category_name
        FROM products p
        JOIN category c ON p.category_id = c.category_id
    """;

    try (Connection conn = myConn.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            // Tạo category
            Category c = new Category();
            c.setCategoryId(rs.getInt("category_id"));
            c.setName(rs.getString("category_name"));

            // Tạo sản phẩm
            Product p = new Product();
            p.setProductId(rs.getInt("product_id"));
            p.setName(rs.getString("name"));
            p.setCategory(c); // set đầy đủ
            p.setPrice(rs.getDouble("price"));
            p.setDescription(rs.getString("description"));
            p.setImage(rs.getString("image"));

            list.add(p);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

}
