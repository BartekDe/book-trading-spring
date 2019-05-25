package pl.bartekde.booktradingspring.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.bartekde.booktradingspring.entity.User;
import pl.bartekde.booktradingspring.user.CrmUser;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);
    
    User findById(int id);

    void save(CrmUser crmUser);
}
