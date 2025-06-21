/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
package Model;

import Object.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    private MyConnection myConnection;

    public UserModel() {
        myConnection = new MyConnection();
    }

    public User authenticateUser(String employeeId, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = myConnection.getConnection();
            String query = "SELECT * FROM users WHERE employee_id = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, employeeId);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                    resultSet.getString("employee_id"),
                    resultSet.getString("password"),
                    resultSet.getString("full_name"),
                    resultSet.getString("role")
                );
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }

        return user;
    }
}