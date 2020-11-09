package structure.dao;

import structure.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getUser(int id);
    void remove(int id);
    void upDate(int id, User user);
}
