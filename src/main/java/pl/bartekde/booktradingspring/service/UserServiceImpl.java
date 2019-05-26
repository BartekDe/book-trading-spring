package pl.bartekde.booktradingspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartekde.booktradingspring.dao.RoleDao;
import pl.bartekde.booktradingspring.dao.UserDao;
import pl.bartekde.booktradingspring.entity.Role;
import pl.bartekde.booktradingspring.entity.User;
import pl.bartekde.booktradingspring.user.CrmUser;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder passwordEncoder) {
    	this.userDao = userDao;
    	this.roleDao = roleDao;
    	this.passwordEncoder = passwordEncoder;
    	
	}

    @Override
    @Transactional
    public User findByUsername(String username) {
        // check in the database (DataAccessObject) for the user
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();

        user.setUsername(crmUser.getUsername());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getFirstName());
        user.setCity(crmUser.getCity());
        user.setState(crmUser.getState());

        // give user a default role - USER
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));

        userDao.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

	@Override
    @Transactional
    public User findById(long id) {
		return userDao.findById(id);
	}
}
