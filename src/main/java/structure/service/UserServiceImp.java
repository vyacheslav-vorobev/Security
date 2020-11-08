package structure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import structure.dao.UserDaoImp;
import structure.model.User;

import java.beans.Transient;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDaoImp userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional
    @Override
    public User getUser(long series){
        return userDao.getUser(series);
    }
}
