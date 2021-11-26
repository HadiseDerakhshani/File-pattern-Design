package dao_question5;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends Dao {
    private List<Integer> studentPrimaryKey;

    public StudentDao() throws SQLException, ClassNotFoundException {
        if (getGetConnection() != null) {
            DatabaseMetaData metaData = getGetConnection().getMetaData();
            ResultSet tables = metaData.getTables(null, null, "student_file", null);
            if (!tables.next()) {
                System.out.println("Table is not exist");
            }
        }
        studentPrimaryKey = new ArrayList<>();
    }

    @Override
    public void insertToTable(List<Integer> listCurse) throws SQLException {
        try {
            int count = 0;
            CSVReader reader = new CSVReader(new FileReader(getFilePath1()));
            String insertQuery = "Insert into student_file (name,curse_id) values (?,?)";
            PreparedStatement statement = getGetConnection().prepareStatement(insertQuery,
                    Statement.RETURN_GENERATED_KEYS);
            String[] data = null;
            reader.readNext();
            while ((data = reader.readNext()) != null) {
                statement.setString(1, data[1]);
                statement.setInt(2, listCurse.get(count++));
                statement.executeLargeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    addListPrimaryKey(resultSet.getInt(1));
                }
                count++;
            }
            statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void addListPrimaryKey(int id) {
        studentPrimaryKey.add(id);
    }
}
