package com.ncepu.cloudyilaboratory.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToMysql {

    public static void main(String[] args) throws SQLException {
        new com.mysql.jdbc.Driver();

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/spring_demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior"
                        + "=convertToNull&allowMultiQueries=true",
                "root",
                "passwd");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select userName, accountName, description from `user`;");
        String username = null;
        while(resultSet.next()) {
            username = resultSet.getString(1);
        }


        resultSet.close();
        statement.close();
        connection.close();
        System.out.println(username);

    }
}
