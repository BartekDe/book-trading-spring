package pl.bartekde.booktradingspring.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import pl.bartekde.booktradingspring.entity.User;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

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
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
    }

	@Override
	public User findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = session.createQuery("from User where id=:id", User.class);
		theQuery.setParameter("id", id);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}
		return theUser;
	}
}
