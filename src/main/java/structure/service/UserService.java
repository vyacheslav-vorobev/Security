package structure.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import structure.model.User;
import java.util.List;

@Service
public interface UserService /* extends UserDetailsService */{
    void addUser(User user);
    List<User> listUsers();
    User getUser(Long series);
    void remove(Long id);
    void upDate(Long id, User user);
    User findByUserName(String login);
    Long getIdByLogin(String login);
}
