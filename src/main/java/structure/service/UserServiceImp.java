package structure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import structure.dao.UserDaoImp;
import structure.model.User;
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
    public User getUser(int series){
        return userDao.getUser(series);
    }
    @Transactional
    @Override
    public  void upDate(int id, User user) {
        userDao.upDate(id,user);
    }
    @Transactional
    @Override
    public void remove(int id) {
        userDao.remove(id);
    }
}
