package pl.bartekde.booktradingspring.dao;

import pl.bartekde.booktradingspring.entity.Offer;

public interface OfferDao {

    Offer findByBookTitle(String bookTitle);

    Offer findById(long id);

    void save(Offer offer);

}
