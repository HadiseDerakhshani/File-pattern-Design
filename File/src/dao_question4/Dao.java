package dao_question4;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Data
public abstract class Dao {
    private Connection getConnection = null;
    private String filePath1 = "E:\\Maktab_exercise\\HW13\\File-pattern-Design\\File\\resurces\\file.csv";

    public Dao() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        getConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab58", "root",
                "SAMAseven@7");
    }

    public abstract void insertToTable(List<Integer> list) throws SQLException;


}
