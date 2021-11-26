package dao_question4;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            getGetConnection().setAutoCommit(false);
            String sql = "INSERT INTO rateing (rate,time_stamp,comment) VALUES (?, ?, ?)";
            PreparedStatement statement = getGetConnection().prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            BufferedReader lineReader = new BufferedReader(new FileReader(getFilePath1()));
            String lineText = null;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String timeStamp = data[2];
                double rate = Double.parseDouble(data[3]);
                String comment = data[4];
                statement.setDouble(1, rate);
                statement.setString(2, timeStamp);
                statement.setString(3, comment);
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
        try {
            CourseDao courseDao = new CourseDao();
            courseDao.insertToTable(this.getRatingPrimaryKey());
            this.getRatingPrimaryKey();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addListPrimaryKey(int id) {
        ratingPrimaryKey.add(id);

    }

}
