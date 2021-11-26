package dao_question4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

            getGetConnection().setAutoCommit(false);
            String sql = "INSERT INTO student_file (name,curse_id) VALUES (?, ?)";
            PreparedStatement statement = getGetConnection().prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            BufferedReader lineReader = new BufferedReader(new FileReader(getFilePath1()));
            String lineText = null;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String name = data[1];
                statement.setString(1, name);
                statement.setInt(2, listCurse.get(count++));
                statement.executeLargeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    addListPrimaryKey(rs.getInt(1));
                }
            }
            lineReader.close();
            statement.executeBatch();
            getGetConnection().commit();
            getGetConnection().close();
        } catch (
                SQLException | IOException ex) {
            ex.printStackTrace();
            getGetConnection().rollback();
        }
    }


    public void addListPrimaryKey(int id) {
        studentPrimaryKey.add(id);
    }
}
