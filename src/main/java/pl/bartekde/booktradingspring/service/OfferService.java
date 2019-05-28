package pl.bartekde.booktradingspring.service;

import pl.bartekde.booktradingspring.entity.Offer;

public interface OfferService {

    Offer findByBookTitle(String bookTitle);

    Offer findById(long id);

    void save(Offer offer);
}
