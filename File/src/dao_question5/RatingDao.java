package dao_question5;

import com.opencsv.CSVReader;
import lombok.Data;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class RatingDao extends Dao {
    private List<Integer> ratingPrimaryKey;
    public RatingDao() throws SQLException, ClassNotFoundException {
        if (getGetConnection() != null) {
            DatabaseMetaData metaData = getGetConnection().getMetaData();
            ResultSet tables = metaData.getTables(null, null, "rateing", null);
            if (!tables.next()) {
                System.out.println("Table is not exist");
            }
        }
        ratingPrimaryKey = new ArrayList<>();
    }

    @Override
    public void insertToTable(List<Integer> list) throws SQLException {
        try {
            CSVReader reader = new CSVReader(new FileReader(getFilePath1()));
            String insertQuery = "Insert into rateing (rate,time_stamp,comment) values (?,?,?)";
            PreparedStatement statement = getGetConnection().prepareStatement(insertQuery,
                    Statement.RETURN_GENERATED_KEYS);
            String[] data = null;
            reader.readNext();
            while ((data = reader.readNext()) != null) {
                statement.setDouble(1, Double.parseDouble(data[3]));
                statement.setString(2, data[2]);
                statement.setString(3, data[4]);
                statement.executeLargeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    addListPrimaryKey(resultSet.getInt(1));
                }
            }
            statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            CourseDao courseDao = new CourseDao();
            courseDao.insertToTable(this.getRatingPrimaryKey());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addListPrimaryKey(int id) {
        ratingPrimaryKey.add(id);

    }

}
