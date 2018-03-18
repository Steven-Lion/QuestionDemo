package model;

/**
 * Created by Steven on 19/10/2017.
 */
import org.springframework.data.repository.Repository;
import model.User;

public interface UserRepository extends Repository<User,Long> {

}
