import dao.RatingDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        RatingDao ratingDao = new RatingDao();
        ratingDao.insertToTable();
        System.out.println("-----------------------");
        ratingDao.getPrimaryKey().stream().forEach(System.out::println);
      /*  Course Name,Student Name,Timestamp,Rating,Comment
        "Java Servlet JSP and Hibernate",Praveen ,2019-07-31
        19:10:13,5.0,"excellent teaching "
        "Java Microservices Masterclass",Van Hoang ,2019-04-23
        09:48:58,4.5,"The course is great "
        "Java Servlet JSP and Hibernate",Van Hoang ,2019-04-23
        09:48:58,4.5,"The course is great "
        "Python for Data Science",Dhara Patel,2019-06-18
        02:50:17,5.0,"Amazing experience after this course.Thank you,
        instructor "
        "Design Patterns in Java",Dhara Patel,2019-06-28
        21:46:56,5.0,"Great Experience, I love this course "*/

    }
}
