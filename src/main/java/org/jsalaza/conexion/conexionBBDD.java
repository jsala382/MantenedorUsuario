package org.jsalaza.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBBDD {
    private static String  url = "jdbc:mysql://localhost:3306/tabla_usuario?serverTimezone=UTC";
    private  static String username="root";
    private static String password="root";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection==null){
            connection= DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}
