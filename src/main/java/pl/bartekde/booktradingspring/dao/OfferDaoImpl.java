package pl.bartekde.booktradingspring.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import pl.bartekde.booktradingspring.entity.Offer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OfferDaoImpl implements OfferDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Offer findByBookTitle(String bookTitle) {

        Session session = entityManager.unwrap(Session.class);

        Query<Offer> theQuery = session.createQuery("from Offer where bookTitle=:bookTitle", Offer.class);
        theQuery.setParameter("bookTitle", bookTitle);

        Offer theOffer = null;
        try {
            theOffer = theQuery.getSingleResult();
        } catch (Exception e) {
            theOffer = null;
        }

        return theOffer;
    }

    @Override
    public Offer findById(long id) {

        Session session = entityManager.unwrap(Session.class);

        Query<Offer> theQuery = session.createQuery("from Offer where id=:id", Offer.class);
        theQuery.setParameter("id", id);

        Offer theOffer = null;
        try {
            theOffer = theQuery.getSingleResult();
        } catch (Exception e) {
            theOffer = null;
        }

        return theOffer;
    }

    @Override
    public void save(Offer offer) {
        Session session = entityManager.unwrap(Session.class);
        session.save(offer);
    }

}
