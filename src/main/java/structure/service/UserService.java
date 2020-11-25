package structure.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import structure.model.Role;
import structure.model.User;

import java.util.Collection;
import java.util.List;

@Service
public interface UserService {
    void addUser(User user);
    List<User> listUsers();
    User getUser(Long series);
    void remove(Long id);
    void upDate(Long id, User user);
    User findByUserName(String login);
    Long getIdByLogin(String login);
}
