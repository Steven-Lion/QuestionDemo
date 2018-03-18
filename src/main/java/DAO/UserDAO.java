package DAO;

import model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Steven on 10/08/2017.
 */
@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String  INSERT_FILELDS = "name ,password , salt , head_url";
    String SELECT_FILEDS = " id, "+ INSERT_FILELDS;
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FILELDS,
            ") values (#{name},#{password},#{salt},#{headUrl})"})
    int addUser(User user);

//    @Select({"select ", SELECT_FILEDS, " from ", TABLE_NAME, " where id=#{id}"})
//    User selectById(int id);
//
//    void updatePassword(User user);
//
//    @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
//    void deleteById(int id);
}
