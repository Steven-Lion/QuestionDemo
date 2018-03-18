import model.User;
import org.apache.ibatis.annotations.Insert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Steven on 19/08/2017.
 */
public class autowired_test {

    @Autowired
    User user ;

    @Test
    public void auto_test(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql ="jdbc:mysql://127.0.0.1:3306/user?characterEncoding = UTF-8";
        String sql_user = "root";
        String sql_pass = "root";
           try(
                   Connection c = DriverManager.getConnection(sql,sql_user,sql_pass);
                   Statement s = c.createStatement();
                   )
           {
               String add_sql = "insert into user values(null,"+"'dd'"+","+"'d2'"+","+"'d3'"+","+"'d4'"+")";

               s.execute(add_sql);
               s.close();
           }catch (SQLException e){
               e.printStackTrace();
           }


        user = new User();
        user.setPassword("Autowired is ok");
        System.out.print(user.getPassword());
    }
}
