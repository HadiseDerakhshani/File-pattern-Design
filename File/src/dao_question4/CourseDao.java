package dao_question4;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            getGetConnection().setAutoCommit(false);
            String sql = "INSERT INTO curse_file (name,rating_id) VALUES (?, ?)";
            PreparedStatement statement = getGetConnection().prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            BufferedReader lineReader = new BufferedReader(new FileReader(getFilePath1()));
            String lineText = null;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String name = data[0];
                statement.setString(1, name);
                statement.setInt(2, listRating.get(count));
                statement.executeLargeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    addListPrimaryKey(rs.getInt(1));
                }
                count++;
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
            StudentDao studentDao = new StudentDao();
            studentDao.insertToTable(this.getCursePrimaryKey());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addListPrimaryKey(int id) {
        cursePrimaryKey.add(id);
    }

}
