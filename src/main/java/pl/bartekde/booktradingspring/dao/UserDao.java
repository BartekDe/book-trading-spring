package pl.bartekde.booktradingspring.dao;

import pl.bartekde.booktradingspring.entity.User;

public interface UserDao {

    User findByUsername(String username);
    
    User findById(int id);

    void save(User user);
}
