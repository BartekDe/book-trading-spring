package pl.bartekde.booktradingspring.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.bartekde.booktradingspring.entity.User;
import org.hibernate.Session;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // read user from database using the username
        Query<User> theQuery = session.createQuery("from User where username=:username", User.class);
        theQuery.setParameter("username", username);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }
        return theUser;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
