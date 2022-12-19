package org.execute;

import java.sql.*;

public class Main {

    private static Connection con;
    private static Statement statement;
    public static void main(String[] args) throws SQLException {

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
            statement = con.createStatement();

            boolean selectResult = statement.execute("select * from product where id between 1 and 2");

            System.out.println(selectResult);

            printResult();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            con.close();
            statement.close();
        }
    }

    private static void printResult() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from product");

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