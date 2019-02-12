package unindra.pemrograman.helper;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionHelper {
    public Connection connection(){
        String usernameDb = "root";
        String passwordDb = "123456";
        String hostDb = "jdbc:mysql://localhost:3306/pantau_dosen?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection conn = null;

        try {
             conn = DriverManager.getConnection(hostDb,usernameDb,passwordDb);

        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }
/*
    public static void main(String[] args) {

        String usernameDb = "root";
        String passwordDb = "123456";
        String hostDb = "jdbc:mysql://localhost:3306/pantau_dosen?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(hostDb,usernameDb,passwordDb);
            log.info("connection established");

        }catch (Exception e){
            e.printStackTrace();
        }

    }*/
}
