package structure.dao;

import structure.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getUser(long id);
    void remove(long id);
    void upDate(User user, long id);
}
