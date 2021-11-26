import dao_question5.RatingDao;
import java.sql.SQLException;
import java.util.List;

public class Question5Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Integer> list = null;
        RatingDao ratingDao = new RatingDao();
        ratingDao.insertToTable(list);
        System.out.println("Add data in DataBase Of File By CsvReader");
    }
}
