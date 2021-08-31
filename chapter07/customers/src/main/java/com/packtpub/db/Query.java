package com.packtpub.db;

import java.sql.*;

public class Query {
    public static void main(String[] args) {
        String sql = "SELECT *  FROM customer ORDER BY username";
        Connection conn;
        Statement statement;
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Long id = resultSet.getLong("CUSTOMER_ID");
                String username = resultSet.getString("USERNAME");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println(id + " " + username + " " + firstName + " " + lastName);
            }

            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();

            conn.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }
}
