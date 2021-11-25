package dao;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public abstract class Dao {
    private Connection getConnection = null;
    private int id;

    private String filePath1 = "E:\\Maktab_exercise\\HW13\\File-pattern-Design\\File\\resurces\\file.csv";

    public Dao() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        getConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab58", "root",
                "SAMAseven@7");
    }

    /* public Connection getGetConnection() {
         return getConnection;
     }

     public String getFilePath1() {
         return filePath1;
     }
 */
    public abstract void insertToTable() throws SQLException;

}
