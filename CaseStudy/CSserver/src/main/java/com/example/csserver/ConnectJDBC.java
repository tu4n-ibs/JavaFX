package com.example.csserver;
import javafx.scene.control.SplitPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String hostname = "localhost:3306";
    private String dbname = "Message";
    private String username = "root";
    private String password = "password";
    private String ConnectionURL = "jdbc:mysql://" + hostname + "/" + dbname;

    public Connection connection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ConnectionURL,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
