package dao_question5;

import com.opencsv.CSVReader;
import dao_question4.StudentDao;
import lombok.Data;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDao extends Dao {
    private List<Integer> cursePrimaryKey;

    public CourseDao() throws SQLException, ClassNotFoundException {
        if (getGetConnection() != null) {
            DatabaseMetaData metaData = getGetConnection().getMetaData();
            ResultSet tables = metaData.getTables(null, null, "curse_file", null);
            if (!tables.next()) {
                System.out.println("Table is not exist");
            }
        }
        cursePrimaryKey = new ArrayList<>();
    }

    @Override
    public void insertToTable(List<Integer> listRating) throws SQLException {
        try {
            int count = 0;
            CSVReader reader = new CSVReader(new FileReader(getFilePath1()));
            String insertQuery = "Insert into curse_file (name,rating_id) VALUES (?, ?)";
            PreparedStatement statement = getGetConnection().prepareStatement(insertQuery,
                    Statement.RETURN_GENERATED_KEYS);
            String[] data = null;
            reader.readNext();
            while ((data = reader.readNext()) != null) {
                statement.setString(1, data[0]);
                statement.setInt(2, listRating.get(count));
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
        try {
            dao_question4.StudentDao studentDao = new StudentDao();
            studentDao.insertToTable(this.getCursePrimaryKey());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addListPrimaryKey(int id) {
        cursePrimaryKey.add(id);
    }

}
