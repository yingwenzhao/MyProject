import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connectMySQL  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jintangdata?serverTimezone=UTC","root" ,"root" );
        PreparedStatement preparedStatement = connectMySQL.prepareStatement("select now()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Date date= resultSet.getDate("now()");
        System.out.println(date);
        connectMySQL.close();
    }

}
