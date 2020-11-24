package structure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import structure.dao.RoleDao;
import structure.dao.UserDao;
import structure.model.Role;
import structure.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    @Override
    public void addUser(User user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDao.getOne(1L));
//        user.setRoles(roles);
//        userDao.add(user);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional
    @Override
    public User getUser(Long series){
        return userDao.getUser(series);
    }


    @Transactional
    @Override
    public  void upDate(Long id, User user) {
        userDao.upDate(id,user);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        userDao.remove(id);
    }

//    @Transactional
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = userDao.getUserByLogin(login);
//        if(user==null){
//            throw new UsernameNotFoundException(String.format("Юзера с логином %s нет", login));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),mapRolesInGranted(user.getRoles()));
//    }

    private Collection<? extends GrantedAuthority> mapRolesInGranted(Collection<Role> roles){
        return roles.stream().map(a-> new SimpleGrantedAuthority(a.getName())).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public User findByUserName(String login) {
        return userDao.getUserByLogin(login);
    }
}
