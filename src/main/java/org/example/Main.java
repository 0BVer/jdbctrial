package org.example;

import java.sql.*;

public class Main {

    private static Connection con;
    private static Statement statement;
    public static void main(String[] args) throws SQLException {

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
            statement = con.createStatement();

            int i = statement.executeUpdate("update product set `price` = `price` + 10000 where `id` = 1");

            System.out.println(i);

            ResultSet rs = statement.executeQuery("select * from product");
            printResult(rs);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            con.close();
            statement.close();
        }
    }

    private static void printResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " "
                            + rs.getString(2) + " "
                            + rs.getDate(3) + " "
                            + rs.getString(4) + " "
                            + rs.getInt(5)
            );
        }
    }
}