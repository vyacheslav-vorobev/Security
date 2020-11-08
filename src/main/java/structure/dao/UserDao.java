package structure.dao;

import org.springframework.stereotype.Component;
import structure.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("Petya", "tyatyatya", 20));
        users.add(new User("Yura", "rarara", 28));
        users.add(new User("Vyacheslav", "Vorobevevevev",23));
        users.add(new User("Vsadfsdf", "sdfsdf"));
        users.add(new User("Vsadfsdf", "345346445634564564356"));

    }
    public List<User> getAllUsers(){
        return users;
    }
    public User getUser(long id) {
        return users.stream().filter(a -> a.getId()==id).findAny().orElse(null);
    }
    public void saveUser(User user){
        users.add(user);
    }
}
